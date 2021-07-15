package com.kai.controller;

import com.kai.pojo.User;
import com.kai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("/ll")
    public String ll(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model, HttpSession session){
    User user=   userService.ll(username,password);
    if (user==null){
        System.out.println("no");
    }
        System.out.println(user.getId());
        System.out.println(user);
        session.setAttribute("loginUser", user);
        System.out.println(session);
        return "redirect:/home";
    }


    //查询所有用户信息
    @RequestMapping("/ulist")
    public String ulist(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("ulist",userList);
        System.out.println("查询所有用户信息");
        return "admin/ulist";
    }



    //跳转到添加用户信息页面
    @GetMapping("/adduser")
    public String adduser() {
        return "admin/adduser";
    }

    //添加用户信息
    @PostMapping("/newuser")
    public String newuser(User user) {
        System.out.println("newuser = " + user);
        userService.newUser(user);
        return "redirect:/ulist";
    }

    //注册
    @GetMapping("/reguser")
    public String reguser() {
        return "users/reg";
    }
    //注册
    @PostMapping("/reg")
    public String reg(User user) {
        System.out.println("reg = " + user);
        userService.regUser(user);
        return "index";
    }

    //删除
    @GetMapping("/deleuser/{id}")
    public String deleuser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/ulist";
    }


    @GetMapping("/toupuser/{id}")
    public String toupuser(@PathVariable int id, Model model) {
        //查出原来的数据
        User userById = userService.getUserById(id);
        model.addAttribute("upuser", userById);
        return "admin/upuser";
    }






    @PostMapping("/upuser")
    public String upuser(User user){
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:/ulist";
    }



    @RequestMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("=====");
        session.invalidate();
        return "/index";
    }



}

