package com.angenela.controller.admin;

import com.angenela.dao.User;
import com.angenela.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        User user = new User();
        user.setName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));

        boolean decide = userService.login(user);

        if (!decide) {
            request.setAttribute("msg", "用户名或密码错误");
            return "admin/login";
        } else {
            session.setAttribute("userName", user.getName());
            return "redirect:/manage";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

}
