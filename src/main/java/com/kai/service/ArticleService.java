package com.kai.service;

import com.kai.mapper.ArticleMapper;
import com.kai.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService {


    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public boolean publishArticle(Article article) {
        int res = articleMapper.insertArticle(article);
        if (res > 0) {
            return true;
        }
        return false;
    }


    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    //查询帖子列表
    public List<Article> queryArticles(){
        return articleMapper.queryArticles();
    }

    public int deleteArticleById(int id){
        return articleMapper.deleteArticleById(id);
    }

    public int uparticle(Article article){
        return articleMapper.uparticle(article);
    }


}

