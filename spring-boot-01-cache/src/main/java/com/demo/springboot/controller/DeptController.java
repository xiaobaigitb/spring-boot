package com.demo.springboot.controller;

import com.demo.springboot.bean.Department;
import com.demo.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id) {
        return departmentService.getById(id);
    }
}
