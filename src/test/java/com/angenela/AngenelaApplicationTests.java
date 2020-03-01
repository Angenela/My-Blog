//package com.angenela;
//
//import com.angenela.dao.Comment;
//import com.angenela.dao.Tag;
//import com.angenela.exception.CommentExceptionEnum;
//import com.angenela.mapper.ArticleMapper;
//import com.angenela.mapper.CommentMapper;
//import com.angenela.service.tag.TagService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//class AngenelaApplicationTests {
//
//    @Autowired
//    private CommentMapper commentMapper;
//    @Autowired
//    private ArticleMapper articleMapper;
//    @Autowired
//    private TagService tagService;
//
//    @Test
//    void contextLoads() {
//        List<Tag> tags = tagService.tags;
//        for (Tag tag : tags) {
//            System.out.println(tag.getName());
//        }
//    }
//
//}
