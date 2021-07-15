package com.kai.mapper;

import com.kai.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

//    public int insertArticle(Article article);
//    public Article getArticleById(int id);

    //查询所有的文章
    List<Article> queryArticles();

    //新增一个文章
    int insertArticle(Article article);

    //根据文章id查询文章
    Article getArticleById(int id);

    //根据文章id删除文章
    int deleteArticleById(int id);

    int uparticle(Article article);

}
