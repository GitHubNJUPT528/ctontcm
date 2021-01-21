package com.cton.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
@Api(value = "系统主页模块",tags = "系统主页接口")
public class IndexController {

    //跳转到index请求
    @ApiOperation(value = "主页导航",notes = "跳转导index页面")
    @PostMapping("/indexview")
    public String index(){
        System.out.println("跳转到index.html");
        return "index";
    }
}
