package com.kai.controller;

import com.kai.pojo.Section;
import com.kai.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SectionController {

    @Autowired
    private SectionService sectionService;


    @RequestMapping("/getSectionList")
    public String getSectionList(Model model){
        List<Section> sectionList = sectionService.getSectionList();
        model.addAttribute("sectionList",sectionList);
        System.out.println(sectionList);
        return "admin/seclist";

    }


    //跳转到新增版块
    @GetMapping("/addsec")
    public String toaddsec(){
        return "admin/addsec";
    }

    //新增版块
    @PostMapping("/newSection")
    public String newSection(Section section){
        System.out.println("addsec"+ section);
        sectionService.newSection(section);
        return "redirect:/getSectionList";
    }

    //删除版块
    @GetMapping("/deleteSection/{id}")
    public String deleteSection(@PathVariable int id){
        sectionService.deleteSection(id);
        return "redirect:/getSectionList";
    }
    //跳转到游戏信息修改页面
    @GetMapping("/upsec/{id}")
    public String toupsec(@PathVariable int id, Model model) {
        //查出原来的数据
        Section sectionById = sectionService.getSectionById(id);
        model.addAttribute("upsec",sectionById);
        return "admin/upsec";
    }

    //修改游戏信息
    @PostMapping("/upsec")
    public String upsec(Section section){
        sectionService.upSection(section);
        System.out.println(section);
        return "redirect:/getSectionList";
    }




}

