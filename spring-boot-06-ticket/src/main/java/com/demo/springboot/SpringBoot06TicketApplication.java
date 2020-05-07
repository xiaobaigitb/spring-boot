package com.demo.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、将服务注册到dubbo中去
 * 2、引入dubbo依赖
 *  注意：spring boot2.X引入方式如下
                <dependency>
                <groupId>com.alibaba.boot</groupId>
                <artifactId>dubbo-spring-boot-starter</artifactId>
                <version>0.1.0</version>
                </dependency>
                <dependency>
                <groupId>com.101tec</groupId>
                <artifactId>zkclient</artifactId>
                <version>0.10</version>
                </dependency>
 *  3、引入zk客户端
 *         <dependency>
 *             <groupId>com.github.sgroschupf</groupId>
 *             <artifactId>zkclient</artifactId>
 *             <version>0.1</version>
 *         </dependency>
 *  4、在service层加入Service（注意：这个是dubbo的Service注解）将服务发布出去
 *      import org.apache.dubbo.config.annotation.Service;
 *  5、加上@Component注解  将服务注册到spring的容器中
 *  6、启动
 *
 */
@EnableDubbo
@SpringBootApplication
public class SpringBoot06TicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06TicketApplication.class, args);
    }

}
