package com.yupi.usercenter1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yupi.usercenter1.Mapper")
public class UserCenter1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserCenter1Application.class, args);
    }

}
