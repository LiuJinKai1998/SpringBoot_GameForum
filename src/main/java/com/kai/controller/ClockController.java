package com.kai.controller;

import com.kai.pojo.Clock;
import com.kai.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClockController {

    @Autowired
    private ClockService clockService;


    @RequestMapping("/getClockList")
    public String getClockList(Model model){
        List<Clock> clockList = clockService.getClockList();
        model.addAttribute("clockList",clockList);
        System.out.println(clockList);
        return "admin/clocklist";

    }


    //跳转到新增
    @GetMapping("/addclock")
    public String toaddclock(){
        return "admin/addclock";
    }

    //新增
    @PostMapping("/newClock")
    public String newClock(Clock clock){
        System.out.println("newClock"+ clock);
        clockService.newClock(clock);
        return "redirect:/getClockList";
    }

    //删除
    @GetMapping("/deleteClock/{id}")
    public String deleteClock(@PathVariable int id){
        clockService.deleteClock(id);
        return "redirect:/getClockList";
    }

    //跳转到修改
    @GetMapping("/upClock/{id}")
    public String toupClock(@PathVariable int id, Model model) {
        //查出原来的数据
        Clock clockById = clockService.getClockById(id);
        model.addAttribute("clockById",clockById);
        return "admin/upclock";
    }

    //修改信息
    @PostMapping("/upClock")
    public String upClock(Clock clock){
        clockService.upClock(clock);
        System.out.println(clock);
        return "redirect:/getClockList";
    }

    //新增
    @PostMapping("/userClock")
    public String userclock(Clock clock){
        System.out.println("newClock"+ clock);
        clockService.newClock(clock);
        return "redirect:/home";
    }




}

