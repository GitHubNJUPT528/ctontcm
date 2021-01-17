package com.cton.web.system;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cton")
public class SystemController {

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/login")
    public String toLogin(){
        System.out.println("cton");
        return "login";
    }
}


