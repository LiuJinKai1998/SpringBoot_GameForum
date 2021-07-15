package com.kai.service;

import com.kai.mapper.EmployeeMapper;
import com.kai.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /*
     * 根据id查询用户
     */
    public Employee select(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    /*
     * 查询所有用户
     */
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

//            return scoreList.isEmpty() ? null : scoreList.get(0);


    /*
     * 增加保存用户
     */
    public void save(Employee employee) {

        employeeMapper.save(employee);
    }

    /*
     * 根据id删除用户
     */
    public int delete(Integer id) {
        return employeeMapper.delete(id);
    }


    /*
     * 更改用户信息
     */
    public int update(Employee employee) {

        return employeeMapper.update(employee);
    }

}
