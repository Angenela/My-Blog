package com.angenela.controller;

import com.angenela.constant.Tags;
import com.angenela.dao.Article;
import com.angenela.dao.Comment;
import com.angenela.exception.CommentExceptionEnum;
import com.angenela.mapper.TagMapper;
import com.angenela.service.article.ArticleService;
import com.angenela.service.comment.CommentService;
import com.angenela.service.tag.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/article")
    public String article(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                          Model model) {

        PageInfo pageInfo = articleService.splitPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("tags", Tags.getTags());

        return "article";
    }

    @PostMapping(value = "/comment")
    @ResponseBody
    public Object comment(@RequestBody @Valid Comment comment,
                          BindingResult result) {

        List<FieldError> allErrors = result.getFieldErrors();

        ArrayList msg = new ArrayList<>();

        if (allErrors.size() != 0) {
            for (FieldError allError : allErrors) {
                String code = allError.getDefaultMessage();
                CommentExceptionEnum byCode = CommentExceptionEnum.getByCode(Integer.valueOf(code));
                msg.add(byCode.getMsg());
            }
        }

        HashMap<Object, Object> map = new HashMap<>();

        if (msg.size() == 0) {
            comment.setCreateTime(System.currentTimeMillis());
            comment.setAgree(false);
            commentService.createComment(comment);
            map.put("state", 1);
        } else {
            map.put("message", msg);
        }
        return map;
    }

    @GetMapping("/content/{id}")
    public String content(@PathVariable(value = "id") Integer id, Model model) {

        Article article = articleService.byId(id);
        model.addAttribute("content", article);
        model.addAttribute("num", id);

        List<Comment> comments = commentService.byArticleId(id);
        model.addAttribute("comments", comments);

        model.addAttribute("tags", Tags.getTags());

        return "content";
    }

    @GetMapping("/classify/{name}")
    public String classify(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           @PathVariable("name") String name,
                           Model model) {

        PageInfo pageInfo = articleService.classifyByTagName(name, pageNum, pageSize);

//      在文章菜单激活哪个item
        model.addAttribute("active", 2);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("tags", Tags.getTags());

        return "article";
    }

}
