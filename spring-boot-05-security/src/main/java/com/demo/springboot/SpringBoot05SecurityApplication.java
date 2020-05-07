package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入依赖
 *  <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-security</artifactId>
 *  </dependency>
 *  2、配置类
 *      @EnableWebSecurity
 *      public class MySecurityConfig extends WebSecurityConfigurerAdapter
 *      a) 使用@EnableWebSecurity
 *      b) 继承WebSecurityConfigurerAdapter
 *  3、控制访问请求的权限
 */
@SpringBootApplication
public class SpringBoot05SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05SecurityApplication.class, args);
    }
}
