package cn.chuareed.pet_stream_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "cn.chuareed.pet_stream_server.dao")
@SpringBootApplication
public class PetStreamServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetStreamServerApplication.class, args);
    }

}
