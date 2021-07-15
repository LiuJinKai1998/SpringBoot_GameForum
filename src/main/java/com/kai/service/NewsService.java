package com.kai.service;

import com.kai.mapper.NewsMapper;
import com.kai.pojo.Article;
import com.kai.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }

    //用户界面新闻列表
    public List<Article> userNews() {
        return newsMapper.userNews();
    }

    public News getNewsById(int id){
        return newsMapper.getNewsById(id);
    }

    public int addNews(News news){
        return newsMapper.addNews(news);
    }

    public int upNews(News news) {
        return newsMapper.upNews(news);
    }

    public int deleteNews(Integer id) {
        return newsMapper.deleteNews(id);
    }



}
