package com.benjaminbutton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class EstateManagementPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstateManagementPlatformApplication.class, args);
    }

}
