package com.kai.controller;

import com.kai.pojo.Userdata;
import com.kai.service.UserdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserdataController {




    @Autowired
    private UserdataService userdataService;


    @RequestMapping("/auserdatalist")
    public String userdatalist(Model model){
        List<Userdata> userdatalist = userdataService.userdatalist();
        model.addAttribute("auserdatalist",userdatalist);
        System.out.println(userdatalist);
        return "admin/auserdatalist";
    }




    //删除
    @GetMapping("/deleteUserdata/{dataid}")
    public String deleteUserdata(@PathVariable int dataid){
        userdataService.deleteUserdata(dataid);
        return "redirect:/auserdatalist";
    }

    //添加
    @GetMapping("adduserdata")
    public String adduserdata(){
        return "admin/adduserdata";
    }
    @PostMapping("/newUserdata")
    public String newUserdata(Userdata userdata){
        userdataService.newUserdata(userdata);
        System.out.println(userdata);
        return "redirect:/auserdatalist";
    }

    //更新
    @GetMapping("/toupuserdata/{dataid}")
    public String toupuserdata(@PathVariable int dataid, Model model) {
        //查出原来的数据
        Userdata userdataBydataid = userdataService.getUserdataBydataid(dataid);
        model.addAttribute("upuserdata",userdataBydataid);
        return "admin/upuserdata";
    }




    @PostMapping("/upuserdata")
    public String upuserdata(Userdata userdata){
        userdataService.upUserdata(userdata);
        System.out.println("更新操作："+userdata);
        return "redirect:/auserdatalist";
    }

    //个人资料页面
    @GetMapping("/usercontent/{id}")
    public String usercontent(@PathVariable int id, Model model) {
        Userdata userdataByuid = userdataService.getUserdataByuid(id);
        model.addAttribute("usercontent", userdataByuid);
        System.out.println(userdataByuid);
        if (userdataByuid == null){
            return "users/useraddcontent";
        }else {
            return "users/usercontent";
        }

    }

    @PostMapping("/addcontent")
    public String addcontent(Userdata userdata){
        userdataService.newUserdata(userdata);
        System.out.println(userdata);
        return "redirect:/home";
    }





}

