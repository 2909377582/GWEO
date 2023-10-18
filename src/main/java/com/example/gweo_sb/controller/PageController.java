package com.example.gweo_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*处理根路径("/")的GET请求并返回一个名为 "index" 的视图。这通常用于将请求映射到网站的首页或初始页面。*/
@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}

