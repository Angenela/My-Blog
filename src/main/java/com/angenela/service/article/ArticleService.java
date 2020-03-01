package com.angenela.service.article;

import com.angenela.dao.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {

    Article byId(Integer id);

    Article byId(Integer id, boolean toHtml);

    void createArticle(Article article);

    PageInfo splitPage(Integer pageNum, Integer pageSize);

    void updateArticle(Article article);

    PageInfo classifyByTagName(String name, Integer pageNum, Integer size);
}
