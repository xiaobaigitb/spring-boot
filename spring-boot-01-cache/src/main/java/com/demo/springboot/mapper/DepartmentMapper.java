package com.demo.springboot.mapper;

import com.demo.springboot.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department findById(Integer id);
}
