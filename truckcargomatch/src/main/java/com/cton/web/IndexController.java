package com.cton.web;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
public class IndexController {

    //跳转到index请求
    @RequestMapping("/indexview")
    public String index(){
        System.out.println("跳转到index.html");
        return "index";
    }
}
