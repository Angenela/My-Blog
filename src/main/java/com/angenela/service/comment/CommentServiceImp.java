package com.angenela.service.comment;

import com.angenela.dao.Comment;
import com.angenela.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void createComment(Comment comment) {
        commentMapper.createComment(comment);
    }

    @Override
    public List<Comment> getAllNotAgree() {
        List<Comment> allNotAgree = commentMapper.getAllNotAgree();
        return allNotAgree;
    }

    @Override
    public void agree(Integer id) {
        commentMapper.agree(id);
    }

    @Override
    public List<Comment> byArticleId(Integer articleId) {

        PageHelper.orderBy("create_time desc");
        List<Comment> comments = commentMapper.byArticleId(articleId);

        return comments;
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentMapper.deleteCommentById(id);
    }
}
