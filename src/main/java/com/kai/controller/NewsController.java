package com.kai.controller;

import com.kai.pojo.Article;
import com.kai.pojo.News;
import com.kai.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;


    @RequestMapping("/getNewsList")
    public String getNewsList(Model model){
        List<News> newsList = newsService.getNewsList();
        model.addAttribute("newsList",newsList);
        return "admin/anewslist";
    }

    @RequestMapping("/userNews")
    public String userNews(Model model){
        List<Article> userNews = newsService.userNews();
        model.addAttribute("userNews",userNews);
        return "users/usernews";

    }


    //跳转到
    @GetMapping("/toaddNews")
    public String toaddNews(){
        return "admin/addnews";
    }

    //新增
    @PostMapping("/addNews")
    public String addNews(News news){
        System.out.println("addNews"+ news);
        newsService.addNews(news);
        return "redirect:/getNewsList";
    }

    //删除
    @GetMapping("/deleteNews/{id}")
    public String deleteNews(@PathVariable int id){
        newsService.deleteNews(id);
        return "redirect:/getNewsList";
    }

    //跳转到
    @GetMapping("/upNews/{id}")
    public String toupNews(@PathVariable int id, Model model) {
        //查出原来的数据
        News newsById = newsService.getNewsById(id);
        model.addAttribute("newsById",newsById);
        return "admin/upnews";
    }

    //修改信息
    @PostMapping("/upNews")
    public String upNews(News news){
        newsService.upNews(news);
        System.out.println(news);
        return "redirect:/getNewsList";
    }




}

