package com.cton.web.system;


import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.model.MatchDTO;
import com.cton.model.Permission;
import com.cton.model.Role;
import com.cton.model.User;
import com.cton.service.bussiness.TruckCargoMatchingService;
import com.cton.service.perms.PermsService;
import com.cton.service.role.RoleService;
import com.cton.service.user.UserService;
import com.cton.utils.ResultUtil;
import com.github.skjolber.packing.Container;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/cton")
@Api(value = "系统模块",tags = "系统接口")
public class SystemController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermsService permsService;

    @Autowired
    private TruckCargoMatchingService truckCargoMatchingService;


    /**
     * 测试装箱匹配
     */
    @ResponseBody
    @PostMapping("/match")
    public ResultDTO match(double length, double width, double hight, double tvolume,double tmass) {
        List<Object> match = truckCargoMatchingService.aaa(length,width,hight,tvolume,tmass);

        return ResultUtil.success("匹配成功",match);
    }

    /**
     * 跳转到登录页面
     */
    @ApiOperation(value = "登录导航", notes = "跳转导login页面")
    @GetMapping("/login")
    public String toLogin() {
        System.out.println("cton");
        return "login";
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/ListAllUsers")
    @ResponseBody
    public ResultDTO ListAllUsers() {
        List<User> userList = userService.listAllUsers();
        if (null != userList)
            return ResultUtil.success("查询所有用户成功", userList);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(), HttpCode.DATABASEISNULL.getMsg());
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @ApiOperation(value = "查询所有角色", notes = "查询所有角色")
    @GetMapping("/ListAllRoles")
    @ResponseBody
    public ResultDTO ListAllRoles() {
        List<Role> roleList = roleService.listAllRoles();
        if (null != roleList)
            return ResultUtil.success("查询所有角色成功", roleList);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(), HttpCode.DATABASEISNULL.getMsg());
    }

    /**
     * 查询所有权限
     *
     * @return
     */
    @ApiOperation(value = "查询所有权限", notes = "查询所有权限")
    @GetMapping("/ListAllPerms")
    @ResponseBody
    public ResultDTO ListAllPerms() {
        List<Permission> permissionList = permsService.listAllPerms();
        if (null != permissionList)
            return ResultUtil.success("查询所有权限成功", permissionList);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(), HttpCode.DATABASEISNULL.getMsg());
    }


}
