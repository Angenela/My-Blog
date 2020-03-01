package com.angenela.mapper;

import com.angenela.dao.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    Comment byId(@Param("id") Integer id);

    void createComment(Comment comment);

    List<Comment> getAllNotAgree();

    void agree(@Param("id") Integer id);

    List<Comment> byArticleId(@Param("articleId") Integer articleId);

    void deleteCommentById(@Param("id") Integer id);
}
