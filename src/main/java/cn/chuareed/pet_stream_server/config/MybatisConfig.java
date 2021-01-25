package cn.chuareed.pet_stream_server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 16:01
 * @description ：Mybatis配置
 */
@Configuration
@MapperScan("cn.chuareed.pet_stream_server.dao")
public class MybatisConfig {
}
