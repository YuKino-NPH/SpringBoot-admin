package com.yuki.springbootadmin.controller;

import com.yuki.springbootadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping(value = {"/", "/login"})
    public String indexPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName())) {
            session.setAttribute("loginUser", user);
            return "redirect:main.html";
        }
        model.addAttribute("msg", "账号或密码错误");
        return "/login";
    }

    @GetMapping("/main.html")
    public String goMain(HttpSession session) {
        return "main";
    }
}
