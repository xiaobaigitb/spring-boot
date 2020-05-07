package com.demo.springboot.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.springboot.service.TicketService;
import org.springframework.stereotype.Service;

@Service//这里是spring得注解 不再使用dubbo得注解
public class UserService {
    //    @Reference//远程引用  引用得方式根据全类名
//    private TicketService ticketService;
    @Reference
    TicketService ticketService;

    public void hello() {
        String tic = ticketService.getTic();
        System.out.println("买到票了：" + tic);
    }
}
