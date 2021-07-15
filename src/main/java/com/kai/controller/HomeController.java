package com.kai.controller;

import com.kai.pojo.Article;
import com.kai.pojo.Game;
import com.kai.pojo.Special;
import com.kai.pojo.User;
import com.kai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private GameService gameService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SpecialService specialService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;


    //首页
    @RequestMapping("/home")
    public String indexartlist(Model model){
        List<Article> artlist = articleService.queryArticles();
        model.addAttribute("indexartlist",artlist);

        List<Game> games = gameService.getGameList();
        model.addAttribute("indexgame",games);

        List<Special> homespecial = specialService.getSpecialList();
        model.addAttribute("homespecial",homespecial);

        List<Article> homenews = newsService.userNews();
        model.addAttribute("homenews",homenews);



        return "users/game";
    }

    @GetMapping("/main/{id}")
    public String main(@PathVariable int id, Model model) {
        User mainuser = userService.getUserById(id);
        String admin="admin";
        if (mainuser.getPower().equals(admin)){
            return "/dashboard";
        }else {
            System.out.println(mainuser.getPower());
            System.out.println("不是管理员");
            return "redirect:/home";
        }

//        return "/dashboard";


    }



}

