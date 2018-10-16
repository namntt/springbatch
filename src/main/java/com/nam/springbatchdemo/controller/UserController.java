package com.nam.springbatchdemo.controller;

import com.nam.springbatchdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    public String listU(Model model) {
        model.addAttribute("listUser", userService.getAllUser());
        return "index";
    }


    @RequestMapping("/")
    public String showListUser(Model model) {
//        model.addAttribute("listUser", userService.getAllUser());
        return "index";
    }
}
