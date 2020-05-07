package com.demo.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot04TaskApplicationTests {
    /**
     * spring boot 邮件的使用
     *  1、引入邮件发送所需要的依赖
     *         <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-mail</artifactId>
     *         </dependency>
     *  2、自动引入邮件发送工具类   JavaMailSender
     *  3、设置邮件发送所需要的配置项
     *  4、如果想发送复杂（附件）的邮件，则需要使用
     *       MimeMessage mimeMessage = mailSender.createMimeMessage();
     *       MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
     *  5、其中配置文件有
     *      spring.mail.username=820517963@qq.com
     *      spring.mail.password=yzlihqopilkobbic
     *      spring.mail.host=smtp.qq.com
     *      spring.mail.properties.mail.smtp.ssl.enable=true
     */
    @Autowired
    private JavaMailSender mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知，今天开会");
        message.setText("今天7：30");

        message.setTo("576495793@qq.com");
        message.setFrom("820517963@qq.com");
        mailSender.send(message);
    }
    @Test
    void test() throws MessagingException {
        //创建一个复杂的邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessage mimeMessage对象不能直接设置邮件信息
        //第二个参数就是支持文件上传
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知，今天开会");
        helper.setText("<b style='color:red'>今天7：30</b>",true);

        helper.setTo("1096071170@qq.com");
        helper.setFrom("820517963@qq.com");
        //上传文件
        helper.addAttachment("1.jpg",new File("D:\\life\\file\\03-springBoot\\01尚硅谷SpringBoot核心技术篇\\Spring Boot 笔记+课件\\images\\搜狗截图20180129151045.png"));
        helper.addAttachment("2.jpg",new File("D:\\life\\file\\03-springBoot\\01尚硅谷SpringBoot核心技术篇\\Spring Boot 笔记+课件\\images\\template-engine.png"));

        mailSender.send(mimeMessage);
    }

}
