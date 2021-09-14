package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PageController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }

    @RequestMapping("/houtai")
    public String houtai(){
        return "houtai";
    }

    @RequestMapping("/adminIn")
    public String adminIn(){
        return "adminIn";
    }

    @RequestMapping("/customer")
    public String customer(){
        return "customer";
    }

    @RequestMapping("/home")  //查找home的jsp的
    public String home(){
        return "home";
    }

    @RequestMapping("/DengLu")  //查找home的jsp的
    public String DengLu(){
        return "DengLu";
    }
}
