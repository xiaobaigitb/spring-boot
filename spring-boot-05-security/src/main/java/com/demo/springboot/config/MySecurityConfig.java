package com.demo.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //定制授权规则
        //     antMatchers("/").permitAll()  -->允许首页下的所有用户都能访问
        //     .antMatchers("/level1/**").hasRole("VIP1") ---允许VIP1用户访问level1下的所有请求
        //hasRole  角色
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启登陆的功能
//        http.formLogin();
        //自定义登陆页面
        http.formLogin()
                .usernameParameter("name")
                .passwordParameter("pwd")
                .loginPage("/userlogin");
        //1、来到登陆页面
        //2、重定向到login?error
        //3、一旦定制loginPage请求，那么loginPage的post的post就是登陆

        //退出功能
        //logoutSuccessUrl设置注销成功后的页面
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能
        http.rememberMe();
        //登陆成功后  将会在浏览器添加cookie
    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password(passwordEncoder().encode("123456")).roles("VIP1")
                .and()
                .withUser("lisi").password(passwordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and()
                .withUser("wangwu").password(passwordEncoder().encode("123456")).roles("VIP3");
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
