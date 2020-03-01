package com.angenela.controller.admin;

import com.angenela.dao.Article;
import com.angenela.mapper.TagMapper;
import com.angenela.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/admin/article/create")
    public String articleCreate(@RequestParam("title") String title,
                                @RequestParam("tags") String tags,
                                @RequestParam("text") String text,
                                @RequestParam(value = "comment", required = false) boolean comment,
                                @RequestParam("description") String description) {

        Article article = new Article();
        article.setText(text);
        article.setTags(tags);
        article.setTitle(title);
        article.setCreateTime(System.currentTimeMillis());
        article.setDescription(description);
        if (comment) {
            article.setComment(true);
        } else {
            article.setComment(false);
        }
        articleService.createArticle(article);

        return "redirect:/admin/article?status=1";
    }

    @GetMapping("/admin/article")
    public String article() {
        return "admin/createArticle";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {

        Article article = articleService.byId(id, false);
        model.addAttribute("article", article);

        return "admin/editArticle";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,
                       @RequestParam("title") String title,
                       @RequestParam("tags") String tags,
                       @RequestParam(value = "comment",required = false) boolean comment,
                       @RequestParam("text") String text,
                       @RequestParam("description") String description) {
        Article article = new Article();
        article.setText(text);
        article.setTags(tags);
        if (comment) {
            article.setComment(true);
        } else {
            article.setComment(false);
        }
        article.setId(id);
        article.setDescription(description);
        article.setTitle(title);
        articleService.updateArticle(article);
        return "redirect:/content/" + id;
    }

}
