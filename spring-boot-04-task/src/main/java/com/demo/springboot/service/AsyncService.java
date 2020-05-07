package com.demo.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步得作用就是程序先相应
 * 后台代码继续执行
 * 异步使用方式是
 *  1、在主程序上加上  @EnableAsync //开启一部功能注解
 *  2、在需要异步的方法上添加   @Async
 */
@Service
public class AsyncService {
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
            System.out.println("发送邮件");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
