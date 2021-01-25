package cn.chuareed.pet_stream_server.config;

import cn.chuareed.pet_stream_server.dao.UserDao;
import cn.chuareed.pet_stream_server.service.UserService;
import cn.chuareed.pet_stream_server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 18:58
 * @description ： Spring Security配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final CustomFilterInvocationSecurityMetadataSource metadataSource;

    public SecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
        this.metadataSource = metadataSource;
    }
}
