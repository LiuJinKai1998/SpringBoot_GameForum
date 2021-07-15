package com.kai.controller;


import com.alibaba.fastjson.JSONObject;
import com.kai.pojo.Article;
import com.kai.pojo.Hpost;
import com.kai.pojo.Section;
import com.kai.service.ArticleService;
import com.kai.service.GameService;
import com.kai.service.HpostService;
import com.kai.service.SectionService;
import com.kai.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private GameService gameService;

    @Autowired
    private HpostService hpostService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/publish")
    @ResponseBody
    public String publishArticle(Article article,Model model) {
        boolean res = articleService.publishArticle(article);
        System.out.println(article);
        if (res) {
            return "success";
        }
        return "false";
    }




    @RequestMapping("/image/upload")
    @ResponseBody
    // 注意RequestParam中的name，不可改。
    public JSONObject imageUpload(@RequestParam("editormd-image-file") MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if (image != null) {
            String path = FileUtils.uploadFile(image);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success!");
            return jsonObject;
        }
        jsonObject.put("success", 0);
        jsonObject.put("message", "upload error!");
        return jsonObject;
    }


    @RequestMapping("/get/{id}")
    public ModelAndView getArticleById(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Article article = articleService.getArticleById(id);
        List<Hpost> hpostList = hpostService.getHpostList();
        modelAndView.addObject("userhlist",hpostList);
        modelAndView.setViewName("article");
        if (article == null) {
            modelAndView.addObject("article", new Article());
        }
        modelAndView.addObject("article", article);
        return modelAndView;
    }


    @RequestMapping("/articlelist")
    public String queryArticles(Model model){
        List<Article> articleList = articleService.queryArticles();
        model.addAttribute("articlelist",articleList);
        System.out.println("帖子列表查询");
        return "admin/articlelist";
    }


    @RequestMapping("/artlist")
    public String artlist(Model model){
        List<Article> artlist = articleService.queryArticles();
        model.addAttribute("artlist",artlist);
        System.out.println("帖子列表查询");
        return "users/artlist";
    }




    //删除帖子
    @GetMapping("/deleteArticleById/{id}")
    public String deleteArticleById(@PathVariable int id){
        articleService.deleteArticleById(id);
        return "redirect:/article/articlelist";
    }

    //修改帖子
    @GetMapping("/touparticle/{id}")
    public String touparticle(@PathVariable int id, Model model) {
        Article articleById = articleService.getArticleById(id);
        model.addAttribute("uparticle",articleById);
        List<Section> sectionList = sectionService.getSectionList();
        model.addAttribute("upsec",sectionList);
        return "admin/uparticle";
    }

    @PostMapping("/uparticle")
    public String uparticle(Article article){
        articleService.uparticle(article);
        System.out.println(article);
        return "redirect:/article/articlelist";
    }


}
