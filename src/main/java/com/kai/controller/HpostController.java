package com.kai.controller;

import com.kai.pojo.Hpost;
import com.kai.service.HpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HpostController {

    @Autowired
    private HpostService hpostService;

    @RequestMapping("/ahpostlist")
    public String ahpostlist(Model model){
        List<Hpost> ahpostList = hpostService.getHpostList();
        model.addAttribute("ahpostList",ahpostList);
        System.out.println("查询所有跟帖信息");
        return "admin/ahpostlist";
    }


    @PostMapping("/newhpost")
    @ResponseBody
    public String newhpost(Hpost hpost) {
        System.out.println("newhpost = " + hpost);
        boolean res = hpostService.newHpost(hpost);
        if (res) {
            return "回帖成功";
        }
        return "回帖失败";
    }



    //删除
    @GetMapping("/delehpost/{hid}")
    public String deleuser(@PathVariable int hid) {
        hpostService.deletHpost(hid);
        return "redirect:/ahpostlist";
    }


    @GetMapping("/touphpost/{hid}")
    public String touphpost(@PathVariable int hid, Model model) {
        //查出原来的数据
        Hpost hpostById = hpostService.getHpostById(hid);
        model.addAttribute("uphpost",hpostById);
        return "admin/uphpost";
    }


    @PostMapping("/uphpost")
    public String uphpost(Hpost hpost){
        hpostService.upHpost(hpost);
        System.out.println(hpost);
        return "redirect:/ahpostlist";
    }



}

