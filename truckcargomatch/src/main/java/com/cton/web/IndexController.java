package com.cton.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@CrossOrigin
@Controller
@Api(value = "系统主页模块",tags = "系统主页接口")
public class IndexController {

    //跳转到index请求
    @ApiOperation(value = "主页导航",notes = "跳转导index页面")
    @GetMapping("/indexview")
    public String index(){
        System.out.println("跳转到index.html");
        return "index";
    }


    /**
     * 分页查询两种写法     用到时可参考
     */
//    public PageInfo  findItemByPage(Map<String,Object> queryMap,int currentPage,int pageSize) {
//
//        PageHelper.startPage(currentPage, pageSize);
//        List<Item> itemsList = itemMapper.findItem(queryMap); //查询商品
//
//        PageInfo info=new PageInfo(itemsList);//1、PageInfo 是 pagehelper中内值的分页的信息类
//
//        System.out.println(info.getTotal());//总条数
//        System.out.println(info.getList());//显示的数据
//
//        return info;  // 返回值是 PageInfo
//    }
//
//    public PageBean<Item> findItemByPage(Map<String,Object> queryMap,int currentPage,int pageSize) {
//
//        PageHelper.startPage(currentPage, pageSize);
//        List<Item> itemsList = itemMapper.findItem(queryMap); //查询商品
//
//        // 2、也可以自定义分页信息
//        int countNums = itemService.countItem(queryMap);      //总记录数
//        PageBean<Item> pageData = new PageBean<>(currentPage, pageSize, countNums);
//        pageData.setItems(itemsList);
//        return pageData;  // 返回值是 PageBean<Item>
//    }
}
