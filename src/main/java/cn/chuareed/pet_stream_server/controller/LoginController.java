package cn.chuareed.pet_stream_server.controller;

import cn.chuareed.pet_stream_server.Util.VerificationCodeUtil;
import cn.chuareed.pet_stream_server.common.ResultWrapper;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 16:37
 */
@Log4j2
@RestController
public class LoginController extends BaseController {
    @GetMapping("/login")
    public ResultWrapper login() {
        return ResultWrapper.error("您还没登录呢，快去登陆吧。");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse response) {
        VerificationCodeUtil code = new VerificationCodeUtil();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verificationCode", text);
        try {
            code.output(image, response.getOutputStream());
        } catch (IOException e) {
            log.error(e.toString());
        }
    }
}
