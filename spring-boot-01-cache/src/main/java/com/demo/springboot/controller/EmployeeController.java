package com.demo.springboot.controller;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp/update")
    public Employee getEmp(Employee employee) {
        return employeeService.update(employee);
    }
    @GetMapping("/emp/delete")
    public String delete(Integer id) {
        employeeService.delete(id);
        return "SUCC";
    }

    @GetMapping("/emp/getByName")
    public Employee delete(String lastName) {
        return employeeService.getBuName(lastName);
    }

}
