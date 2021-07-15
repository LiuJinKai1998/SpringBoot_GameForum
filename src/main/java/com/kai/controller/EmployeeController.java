package com.kai.controller;

import com.kai.pojo.Employee;
import com.kai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //查询全部员工信息
    @RequestMapping("/emps")
    public String userList(Model model) {
//        Collection<Employee> employees = employeeService.getAll();
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";

    }

    //转到员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpateEmp(@PathVariable int id, Model model) {
        //查出原来的数据
        Employee employee = employeeService.select(id);

        model.addAttribute("update", employee);
        return "emp/update";
    }


    //修改员工信息
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeService.update(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp")
    public String toadd() {
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("employee = " + employee);
        employeeService.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }


//    //添加员工信息
//    @PostMapping("/emp")
//    public String addEmp(Employee employee){
//        System.out.println("employee = " + employee);
//        //保存员工信息
//        employeeService.save(employee);
//        return "redirect:/emps";
//    }
//


}

