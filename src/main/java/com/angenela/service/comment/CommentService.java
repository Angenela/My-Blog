package com.angenela.service.comment;

import com.angenela.dao.Comment;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);

    List<Comment> getAllNotAgree();

    void agree(Integer id);

    List<Comment> byArticleId(Integer articleId);

    void deleteCommentById(Integer id);
}
