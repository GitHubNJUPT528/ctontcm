package com.cton.web.permission;


import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.model.Permission;
import com.cton.service.perms.PermsService;
import com.cton.service.role.RoleService;
import com.cton.utils.PageBean;
import com.cton.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源管理Controller
 * Created by macro on 2020/2/4.
 */
@Controller
@CrossOrigin
@Api(value = "后台权限管理",tags = "后台权限接口")
@RequestMapping("/permission")
public class PermissionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermsService permsService;

    @ApiOperation("添加后台权限")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO create(@RequestBody Permission permission) {
        int count = permsService.insertPermissionSelective(permission);
        if (count > 0) {
            return ResultUtil.success("添加后台权限成功");
        } else {
            throw new BusinessException(HttpCode.FAIL.getCode(),"添加后台权限失败");
        }
    }

    @ApiOperation("修改后台权限")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO update(@PathVariable Integer id,
                               @RequestBody Permission permission) {
        permission.setId(id);
        int count = permsService.updatePermissionByIdSelective(permission);
        if (count > 0) {
            return ResultUtil.success("修改后台权限成功");
        } else {
            throw new BusinessException(HttpCode.FAIL.getCode(),"修改后台权限失败");
        }
    }

    @ApiOperation("根据ID获取权限详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getPermission(@PathVariable Integer id) {
        Permission permission = permsService.selectPermissionById(id);
        if (null!=permission) {
            return ResultUtil.success("根据ID获取权限详情成功");
        } else {
            throw new BusinessException(HttpCode.FAIL.getCode(),"根据ID获取权限详情失败");
        }
    }

    //权限和角色的上级关系目前都没处理

    @ApiOperation("根据ID删除后台权限")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO delete(@PathVariable Integer id) {
        int count = permsService.deletePermissionById(id);
        if (count > 0) {
            return ResultUtil.success("根据ID删除后台权限成功");
        } else {
            throw new BusinessException(HttpCode.FAIL.getCode(),"根据ID删除后台权限失败");
        }
    }

    @ApiOperation("分页模糊查询后台权限")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO listLike(@RequestParam(required = false) Integer type,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
        PageBean<Permission> pageBeanPermission = permsService.listAllPermsByKeyword(type,nameKeyword, urlKeyword, pageSize, currentPage);
        if (null!=pageBeanPermission.getItems())
            return ResultUtil.success("分页模糊查询后台权限成功",pageBeanPermission);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"分页模糊查询后台权限失败");
    }

    @ApiOperation("查询所有后台权限")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO listAll() {
        List<Permission> permissionList = permsService.listAllPerms();
        if(null!=permissionList)
            return ResultUtil.success("查询所有后台权限成功",permissionList);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"查询所有后台权限失败");
    }
}
