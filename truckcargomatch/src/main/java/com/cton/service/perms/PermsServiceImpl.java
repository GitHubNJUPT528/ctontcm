package com.cton.service.perms;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.mapper.PermissionMapper;
import com.cton.model.Permission;
import com.cton.model.User;
import com.cton.utils.PageBean;
import com.cton.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class PermsServiceImpl implements PermsService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> listAllPerms() {
        return permissionMapper.listAllPerms();
    }

    @Override
    public PageBean<Permission> listAllPermsByKeyword(Integer type, String nameKeyword, String urlKeyword, Integer pageSize, Integer currentPage){
        PageHelper.startPage(currentPage, pageSize);
        List<Permission> permissionList = permissionMapper.listAllPermsByKeyword(type, nameKeyword, urlKeyword);

        // 自定义分页信息
        int countNums = permissionList.size();     //总记录数
        PageBean<Permission> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(permissionList);
        return pageData;

    }

    @Override
    public String selectPermNameByPermId(Integer permId){
        return permissionMapper.selectPermNameByPermId(permId);
//        String returnString = permissionMapper.selectPermNameByPermId(permId);
//        if(StringUtils.isNullOrEmpty(returnString)){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据权限ID查找权限名失败");
//        }else{
//            return ResultUtil.success("根据权限ID查找权限名成功",returnString);
//        }
    }

    @Override
    public Permission selectPermissionById(Integer id) {
        return permissionMapper.selectPermissionById(id);
//        Permission returnPermission = permissionMapper.selectPermissionById(id);
//        if(null == returnPermission){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID查找权限失败");
//        }else{
//            return ResultUtil.success("根据主键ID查找权限成功",returnPermission);
//        }
    }

    @Override
    public Permission selectPermissionByPermName(String permname) {
        return permissionMapper.selectPermissionByPermName(permname);
//        Permission returnPermission = permissionMapper.selectPermissionByPermName(permname);
//        if(null == returnPermission){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据权限ID查找权限失败");
//        }else{
//            return ResultUtil.success("根据权限ID查找权限成功",returnPermission);
//        }
    }

    @Override
    public Integer deletePermissionById(Integer id) {
        return permissionMapper.deletePermissionById(id);
//        int returnNumber = permissionMapper.deletePermissionById(id);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID删除权限失败");
//        }else{
//            return ResultUtil.success("根据主键ID删除权限成功");
//        }
    }

    @Override
    public Integer deletePermissionByPermName(String permname) {
        return permissionMapper.deletePermissionByPermName(permname);
//        int returnNumber = permissionMapper.deletePermissionByPermName(permname);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据权限ID删除权限失败");
//        }else{
//            return ResultUtil.success("根据权限ID删除权限成功");
//        }
    }

    @Override
    public Integer insertPermissionSelective(Permission permission) {
        permission.setCreateTime(new Date());
        return permissionMapper.insertPermissionSelective(permission);
//        int returnNumber = permissionMapper.insertPermissionSelective(permission);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增权限失败");
//        }else{
//            return ResultUtil.success("新增权限成功");
//        }
    }

    @Override
    public Integer updatePermissionByIdSelective(Permission permission) {
        permission.setUpdateTime(new Date());
        return permissionMapper.updatePermissionByIdSelective(permission);
//        int returnNumber = permissionMapper.updatePermissionByIdSelective(permission);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID更新权限失败");
//        }else{
//            return ResultUtil.success("根据主键ID更新权限成功");
//        }
    }


}
