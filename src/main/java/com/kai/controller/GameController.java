package com.kai.controller;

import com.kai.pojo.Game;
import com.kai.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    //查询所有游戏信息
    @RequestMapping("/gamelist")
    public String getGamesList(Model model){
        List<Game> games = gameService.getGameList();
        model.addAttribute("gamelist",games);
        System.out.println("ok");
        return "users/gamelist";
    }

    //查询所有游戏信息
    @RequestMapping("/aglist")
    public String aglist(Model model){
        List<Game> gameList = gameService.getGameList();
        model.addAttribute("aglist",gameList);
        System.out.println("管理员游戏列表查询");
        System.out.println(gameList);
        return "admin/aglist";
    }

    //查询所有游戏信息
    @RequestMapping("/artgame")
    public String artgame(Model model){
        List<Game> artgame = gameService.getGameList();
        model.addAttribute("artgame",artgame);
        System.out.println(artgame);
        return "admin/aglist";
    }

    //跳转到添加游戏信息页面
    @GetMapping("/addgame")
    public String toaddgame() {
        return "admin/addgame";
    }

    //添加游戏信息
    @PostMapping("/newgame")
    public String newgame(Game game) {
        System.out.println("newgame = " + game);
        gameService.newGame(game);
        return "redirect:/aglist";
    }

    //删除游戏信息
    @GetMapping("/delegame/{id}")
    public String delegame(@PathVariable int id) {
        gameService.deleteGame(id);
        return "redirect:/aglist";
    }

    //跳转到游戏信息修改页面
    @GetMapping("/toupdategame/{id}")
    public String toupdategame(@PathVariable int id, Model model) {
        //查出原来的数据
        Game gameById = gameService.getGameById(id);
        model.addAttribute("updategame", gameById);
        return "admin/updategame";
    }

    //修改游戏信息
    @PostMapping("/updategame")
    public String updategame(Game game){
        gameService.updateGame(game);
        System.out.println(game);
        return "redirect:/aglist";
    }





}

