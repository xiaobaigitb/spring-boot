package com.demo.springboot.service;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @CacheConfig 缓存注解 抽取缓存的公共配置
 *
 * 缓存默认使用concurrentMapCacheManager = ConcurrentMapCache
 */
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService implements Serializable {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将查询到的数据结果进行缓存  以后相同的数据就不需要往数据库查询
     * <p>
     * 几个属性
     * cacheName/value：缓存的名字
     * key: 缓存数据使用到的key  ----》》》默认的key就是参数
     * condition：指定符合条件的才进行缓存
     * unless：是否缓存  当方法的返回值为true是进行缓存
     * sync：是否异步缓存
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp"/*, condition = "#id>=1", unless = "#event!=null"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "员工");
        Employee byId = employeeMapper.findById(id);
        return byId;
    }

    /**
     * 测试过程
     * 1.查询数据 getEmp
     * 2.再次查询看有没有启用缓存
     * 3.调用Update数据  更新数据库数据
     * 4.再次调用getEmp  查看数据
     * 结果：查询到了数据  但是数据没有变  但是数据库数据时改变的
     * 原因：CachePut做了两个操作
     *      1.逻辑代码（这里是更新）
     *      2.更新缓存（缓存的key是传入的数据）
     *      分析：数据更新和缓存更新都实现了 但是getEmp 做的缓存时id(1),而CachePut更新的缓存的key时（employee）
     *      方案：设置CachePut更新缓存的key
     *      key = "#employee.id"/key = "#result.id"
     * 5.使用CachePut时指定缓存的key为正确的时候 结果成功
     *
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp", key = "#employee.id")
    public Employee update(Employee employee) {
        System.out.println("待更新的数据是：" + employee.toString());
        employeeMapper.update(employee);
        return employee;
    }

    /**
     * 清除缓存
     * key：删除指定key的数据
     * allEntries：删除所有缓存 默认是 false
     * beforeInvocation：执行操作之前清除缓存
     * 如果是 false  如果方法执行出错 则不清楚缓存
     * 如果是 true   无论成功与否都清除缓存
     *
     * @param id
     */
    @CacheEvict(cacheNames = "emp", key = "#id")
    public void delete(Integer id) {
        System.out.println("delete:" + id);
        employeeMapper.delete(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(cacheNames = "emp", key = "#result.id"),
                    @CachePut(cacheNames = "emp", key = "#result.email")
            }
    )
    public Employee getBuName(String lastName) {
        return employeeMapper.findByName(lastName);
    }
}
