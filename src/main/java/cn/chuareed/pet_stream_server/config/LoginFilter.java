package cn.chuareed.pet_stream_server.config;

import cn.chuareed.pet_stream_server.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 17:00
 * @description ： 登录用户过滤器
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    SessionRegistry sessionRegistry;

    public LoginFilter(SessionRegistry registry) {
        sessionRegistry = registry;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("不支持该请求方法！");
        }
        String verificationCode = String.valueOf(request.getSession().getAttribute("verificationCode"));
        if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            Map<String, String> loginData = new HashMap<>();
            try {
                loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (IOException ignored) {
            } finally {
                String code = loginData.get("code");
                checkCode(response, code, verificationCode);
            }
            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            username = username == null ? "" : username.trim();
            if (password == null) password = "";

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, token);
            User user = new User();
            user.setUsername(username);
            sessionRegistry.registerNewSession(request.getSession(true).getId(), user);
            return this.getAuthenticationManager().authenticate(token);
        } else {
            checkCode(response, request.getParameter("code"), verificationCode);
            return super.attemptAuthentication(request, response);
        }
    }

    /**
     * @author Gavin C
     * @date 2021/1/18 18:57
     * @description 判断验证码是否输入正确
     * @param    response 相应
     * @param    code     用户输入的验证码
     * @param    verificationCode 正确的验证码
     */
    private void checkCode(HttpServletResponse response, String code, String verificationCode) {
        if (code == null || verificationCode == null || code.isEmpty() || !verificationCode.equalsIgnoreCase(code)) {
            throw new AuthenticationServiceException("验证码错误。");
        }
    }
}
