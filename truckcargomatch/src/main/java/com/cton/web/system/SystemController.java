package com.cton.web.system;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cton")
@Api(value = "系统登录导航模块",tags = "系统登录导航接口")
public class SystemController {

    /**
     * 跳转到登录页面
     */
    @ApiOperation(value = "登录导航",notes = "跳转导login页面")
    @GetMapping("/login")
    public String toLogin(){
        System.out.println("cton");
        return "login";
    }
}


