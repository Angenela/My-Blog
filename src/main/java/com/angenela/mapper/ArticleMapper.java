package com.angenela.mapper;

import com.angenela.dao.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    Article byId(@Param("id") Integer id);

    void createArticle(Article article);

    List<Article> selectAll();

    Integer count();

    Integer countByTag(@Param("name") String name);

    void updateArticle(Article article);

    List<Article> classifyByTagName(@Param("name") String name);
}
