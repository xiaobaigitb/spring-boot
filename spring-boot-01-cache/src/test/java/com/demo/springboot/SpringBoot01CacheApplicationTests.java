package com.demo.springboot;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.mapper.EmployeeMapper;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;

@SpringBootTest
class SpringBoot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * stringRedisTemplate 是专门来处理字符串对象的  使用起来必须是字符串
     * string（字符串） list（列表） Map  set（散列集合）  zSet（有序集合）
     * stringRedisTemplate.opsForValue()    [string（字符串）]
     * stringRedisTemplate.opsForList();    [list（列表）]
     * stringRedisTemplate.opsForHash();    [Map]
     * stringRedisTemplate.opsForSet();     [set（散列集合）]
     * stringRedisTemplate.opsForZSet();    [zSet（有序集合）]
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v字符串的
    @Autowired
    RedisTemplate redisTemplate;//操作对象的

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().append("string", "zhangsan");
        stringRedisTemplate.opsForList().leftPush("list", "1");
        stringRedisTemplate.opsForHash().hasKey("k", "v");
        stringRedisTemplate.opsForSet().add("sK", "1", "2", "3");
//        stringRedisTemplate.opsForZSet();
    }

    @Autowired
    RedisTemplate<Object, Employee> emredisTemplate;
    @Test
    public void test2() {
        Employee employee = employeeMapper.findById(1);
        emredisTemplate.opsForValue().set("emp", employee);
    }

    @Test
    void contextLoads() {
        Employee byId = employeeMapper.findById(1);
        System.out.println(byId.toString());
    }

}
