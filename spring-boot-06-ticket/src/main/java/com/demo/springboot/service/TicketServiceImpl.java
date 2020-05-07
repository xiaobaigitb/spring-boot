package com.demo.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component//注册到spring容器中
@Service  //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTic() {
        System.out.println("《厉害了，我得国！！！》");
        return "《厉害了，我得国！！！》";
    }
}
