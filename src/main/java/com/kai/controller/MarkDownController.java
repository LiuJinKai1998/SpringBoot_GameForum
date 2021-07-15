package com.kai.controller;


import com.kai.pojo.Game;
import com.kai.pojo.Section;
import com.kai.service.GameService;
import com.kai.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/markdown")
public class MarkDownController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private GameService gameService;

    // 这个接口，主要是进行跳转页面的。
    @RequestMapping("/edit")
    public String edit(Model model) {

        List<Section> sectionList = sectionService.getSectionList();
        model.addAttribute("secname",sectionList);
        System.out.println(sectionList);

        List<Game> artgamelist = gameService.getGameList();
        model.addAttribute("artgamelist",artgamelist);
        System.out.println(artgamelist);


        return "edit";
    }



}

