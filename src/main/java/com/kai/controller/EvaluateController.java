package com.kai.controller;

import com.kai.pojo.Evaluate;
import com.kai.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

//    //查询所有游戏信息
//    @RequestMapping("/getEvaluateList")
//    public String getEvaluateList(Model model){
//        List<Evaluate> evaluateList = evaluateService.getEvaluateList();
//        model.addAttribute("evaluateList",evaluateList);
//        return "users/gamelist";
//    }

    //查询
    @RequestMapping("/getEvaluateList")
    public String getEvaluateList(Model model){
        List<Evaluate> evaluateList = evaluateService.getEvaluateList();
        model.addAttribute("evaluateList",evaluateList);
        System.out.println(evaluateList);
        return "admin/evaluatelist";
    }

//    //查询所有游戏信息
//    @RequestMapping("/artgame")
//    public String artgame(Model model){
//        List<Game> artgame = gameService.getGameList();
//        model.addAttribute("artgame",artgame);
//        System.out.println(artgame);
//        return "admin/aglist";
//    }

    //跳转
    @GetMapping("/addEvaluate")
    public String addEvaluate() {
        return "admin/addevaluate";
    }

    //添加
    @PostMapping("/newEvaluate")
    public String newEvaluate(Evaluate evaluate) {
        System.out.println("newEvaluate = " + evaluate);
        evaluateService.newEvaluate(evaluate);
        return "redirect:/getEvaluateList";
    }

    //删除
    @GetMapping("/deleteEvaluate/{id}")
    public String deleteEvaluate(@PathVariable int id) {
        evaluateService.deleteEvaluate(id);
        return "redirect:/getEvaluateList";
    }

    //跳转到游戏信息修改页面
    @GetMapping("/toupEvaluate/{id}")
    public String toupEvaluate(@PathVariable int id, Model model) {
        //查出原来的数据
        Evaluate evaluateById = evaluateService.getEvaluateById(id);
        model.addAttribute("evaluateById",evaluateById);
        return "admin/upevaluate";
    }

    //修改游戏信息
    @PostMapping("/upEvaluate")
    public String upEvaluate(Evaluate evaluate){
        evaluateService.upEvaluate(evaluate);
        System.out.println(evaluate);
        return "redirect:/getEvaluateList";
    }





}

