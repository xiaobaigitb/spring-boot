package com.demo.springboot.service;

import com.demo.springboot.bean.Department;
import com.demo.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "dept")
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 也可以自动注入 不直接使用cache的操作
     * 使用cacheManager直接往redis里面存放数据
     */
    @Autowired
    CacheManager cacheManager;

//    @Cacheable
    public Department getById(Integer id) {
        System.out.println("查询：" + id);
        Department department = departmentMapper.findById(id);
        Cache dept = cacheManager.getCache("dept");
        dept.put("dept:1", department);
        return department;
    }

}
