package com.cton.web.role;


import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.model.Permission;
import com.cton.model.Role;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 后台用户角色管理Controller
 */
@Controller
@Api(value = "系统角色模块",tags = "系统角色接口")
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermsService permsService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO create(@RequestBody Role role) {
        int count = roleService.createRole(role);
        if (count > 0) {
            return ResultUtil.success("新增角色成功");
        }
        throw new BusinessException(HttpCode.FAIL.getCode(),"新增角色失败");
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO update(@PathVariable Integer id, @RequestBody Role role) {
        role.setId(id);
        int count = roleService.updateRoleByIdSelective(role);
        if (count > 0) {
            return ResultUtil.success("修改角色成功");
        }
        throw new BusinessException(HttpCode.FAIL.getCode(),"修改角色失败");
    }

    @ApiOperation("根据ID删除角色")
    @RequestMapping(value = "/delete/{roleId}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO delete(@PathVariable Integer roleId) {
        int count = roleService.deleteRoleById(roleId);
        if (count > 0) {
            return ResultUtil.success("删除角色成功");
        }
        throw new BusinessException(HttpCode.FAIL.getCode(),"修改角色失败");
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO deleteBatch(@RequestParam("roleId") List<Integer> roleIds) {
        int count = roleService.deleteBatch(roleIds);
        if (count > 0) {
            return ResultUtil.success("批量删除角色成功");
        }
        throw new BusinessException(HttpCode.FAIL.getCode(),"批量删除角色失败");
    }


    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO listAll() {
        List<Role> roleList = roleService.listAllRoles();
        if(null!=roleList)
            return ResultUtil.success("获取所有角色成功",roleList);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"数据库角色查询为空");
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/listLike", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO listAllRolesByKeyword(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
        PageBean<Role> pageBeanRole = roleService.listAllRolesByKeyword(keyword, pageSize, currentPage);
        if (null!=pageBeanRole.getItems())
            return ResultUtil.success("模糊分页查询角色成功",pageBeanRole);
        else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"数据库角色查询为空");
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO updateStatus(@PathVariable Integer id, @RequestParam(value = "status") Integer status) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(status);
        int count = roleService.updateRoleByIdSelective(role);
        if (count > 0) {
            return ResultUtil.success("更新角色状态成功",count);
        }else
            throw new BusinessException(HttpCode.FAIL.getCode(),"更新角色状态失败");
    }


    @ApiOperation("获取角色相关权限")
    @RequestMapping(value = "/listPerms/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO listPerms(@PathVariable Integer roleId) {
        List<Integer> permissionIdsList = roleService.selectPermsIdsByRoleId(roleId);
        List<Permission> permissionList = new ArrayList<>();
        for (Integer permissionId:permissionIdsList){
            permissionList.add(permsService.selectPermissionById(permissionId));
        }
        if(null!=permissionList){
            return ResultUtil.success("获取角色相关权限成功",permissionList);
        }else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"该角色没有权限");
    }


    @ApiOperation("给角色添加权限")
    @RequestMapping(value = "/allocPermission", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO allocPermission(@RequestParam Integer roleId, @RequestParam List<Integer> permissionIds) {
        if (roleService.allocPermission(roleId,permissionIds)==1)
            return ResultUtil.success("给角色添加权限成功");
        else
            throw new BusinessException(HttpCode.FAIL.getCode(),"给角色添加权限失败");
    }

}
