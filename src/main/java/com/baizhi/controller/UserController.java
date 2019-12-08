package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        User us = userService.queryByNameAndWord(user.getName(), user.getPassword());
        HttpSession session = request.getSession();
        if (us == null) {
            return "/ems/user/login";
        } else {
            System.out.println("haha");
            session.setAttribute("user", us);
            return "redirect:/department/showdepartment";
        }

    }

    @RequestMapping("regist")
    public String regist(User user) {
        String s = UUID.randomUUID().toString();
        user.setId(s);
        userService.insertUser(user);
        return "redirect:/ems/user/login.jsp";
    }
}
