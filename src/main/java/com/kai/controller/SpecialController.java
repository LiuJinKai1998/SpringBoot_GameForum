package com.kai.controller;

import com.kai.pojo.Special;
import com.kai.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpecialController {

    @Autowired
    private SpecialService specialService;


    @RequestMapping("/getSpecialList")
    public String getSpecialList(Model model){
        List<Special> specialList = specialService.getSpecialList();
        model.addAttribute("specialList",specialList);
        System.out.println(specialList);
        return "admin/speciallist";

    }


    //跳转到新增
    @GetMapping("/tonewSpecial")
    public String addspecial(){
        return "admin/addspecial";
    }

    //新增
    @PostMapping("/newSpecial")
    public String newSpecial(Special special){
        System.out.println("newSpecial"+ special);
        specialService.newSpecial(special);
        return "redirect:/getSpecialList";
    }


    //删除
    @GetMapping("/deleteSpecial/{id}")
    public String deleteSpecial(@PathVariable int id){
        specialService.deleteSpecial(id);
        return "redirect:/getSpecialList";
    }

    //跳转到修改
    @GetMapping("/upSpecial/{id}")
    public String toupSpecial(@PathVariable int id, Model model) {
        //查出原来的数据
        Special specialById = specialService.getSpecialById(id);
        model.addAttribute("specialById",specialById);
        return "admin/upspecial";
    }

    //修改信息
    @PostMapping("/upSpecial")
    public String upSpecial(Special special){
        specialService.upSpecial(special);
        System.out.println(special);
        return "redirect:/getSpecialList";
    }





}

