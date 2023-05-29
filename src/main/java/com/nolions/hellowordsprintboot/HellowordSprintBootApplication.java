package com.nolions.hellowordsprintboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nolions.hellowordsprintboot.mapper")
public class HellowordSprintBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellowordSprintBootApplication.class, args);
    }

}
