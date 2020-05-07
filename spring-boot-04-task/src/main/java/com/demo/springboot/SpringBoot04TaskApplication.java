package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling  //开启定时任务
@EnableAsync       //开启异步功能注解
@SpringBootApplication
public class SpringBoot04TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04TaskApplication.class, args);
    }

}
