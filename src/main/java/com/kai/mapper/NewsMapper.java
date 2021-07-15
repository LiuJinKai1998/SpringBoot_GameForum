package com.kai.mapper;

import com.kai.pojo.Article;
import com.kai.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface NewsMapper {


    List<News> getNewsList();

    List<Article> userNews();

    //根据id查询信息
    News getNewsById(int id);

    int addNews(News news);

    int upNews(News news);

    int deleteNews(int id);


}
