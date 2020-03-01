package com.angenela.service.article;

import com.angenela.constant.Tags;
import com.angenela.dao.Article;
import com.angenela.mapper.ArticleMapper;
import com.angenela.mapper.TagMapper;
import com.angenela.service.tag.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vladsch.flexmark.ext.gfm.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Article byId(Integer id) {
        return byId(id, true);
    }

    @Override
    public Article byId(Integer id, boolean toHtml) {
        Article article = articleMapper.byId(id);
        String text = article.getText();

        //markdown转html
        if (toHtml) {
            MutableDataSet options = new MutableDataSet();
            options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();

            Node document = parser.parse(text);
            text = renderer.render(document);
            article.setText(text);
        }

        return article;
    }

    @Override
    public void createArticle(Article article) {

        tagMapper.addCountByName(article.getTags());
        Tags.addCountByName(article.getTags());

        articleMapper.createArticle(article);
    }

    @Override
    public PageInfo splitPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Article> articles = articleMapper.selectAll();
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);

        articlePageInfo.setPageNum(pageNum);
        articlePageInfo.setPageSize(pageSize);
        articlePageInfo.setTotal(articleMapper.count());

        return articlePageInfo;
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public PageInfo classifyByTagName(String name, Integer pageNum, Integer size) {

        PageHelper.startPage(pageNum, size);

        List<Article> articles = articleMapper.classifyByTagName(name);

        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);

        articlePageInfo.setPageNum(pageNum);
        articlePageInfo.setPageSize(size);
        articlePageInfo.setTotal(articleMapper.countByTag(name));

        return articlePageInfo;
    }

}
