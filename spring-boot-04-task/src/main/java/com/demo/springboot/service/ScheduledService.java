package com.demo.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * spring boot整合定时任务
 *  1、Application里面加上 @EnableScheduling  //开启定时任务
 *  2、在需要定时的任务上加上   @Scheduled(cron = "0/5 * * * * MON-SAT")
 *      其中cron表达式就是我们定时规则
 */
@Service
public class ScheduledService {

    //second, minute, hour, day of mouth, mouth, day of week
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,2,3,4 * * * * MON-SAT")
//    @Scheduled(cron = "0-5 * * * * MON-SAT")
    @Scheduled(cron = "0/5 * * * * MON-SAT") //   /代表步长 0/5：从0秒开始 每五秒打印一次
    public void hello() {
        System.out.println("hello!!!");
    }
}
