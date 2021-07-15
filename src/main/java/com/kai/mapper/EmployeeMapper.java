package com.kai.mapper;

import com.kai.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface EmployeeMapper {

    //查询全部信息
    List<Employee> getAll();

    //根据id查询信息
    Employee getEmployeeById(int id);

    //新增
    int save(Employee employee);

    //修改
    int update(Employee employee);

    //删除
    int delete(int id);


}
