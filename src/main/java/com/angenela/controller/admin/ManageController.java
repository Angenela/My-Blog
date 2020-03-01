package com.angenela.controller.admin;

import com.angenela.dao.Comment;
import com.angenela.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManageController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/manage")
    public String manage(Model model){

        List<Comment> allNotAgree = commentService.getAllNotAgree();
        model.addAttribute("comments", allNotAgree);

        return "admin/manage";
    }

    @PostMapping("/agree")
    @ResponseBody
    public void agree(@RequestParam("id") Integer id){
        commentService.agree(id);
    }

    @PostMapping("/deleteComment/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id){
        commentService.deleteCommentById(id);

        return "删除成功";
    }

}
