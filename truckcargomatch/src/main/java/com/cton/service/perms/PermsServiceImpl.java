package com.cton.service.perms;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.mapper.PermissionMapper;
import com.cton.model.Permission;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermsServiceImpl implements PermsService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public ResultDTO selectPermNameByPermId(Integer permId){

        String returnString = permissionMapper.selectPermNameByPermId(permId);
        if(StringUtils.isNullOrEmpty(returnString)){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据权限ID查找权限名失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据权限ID查找权限名成功",returnString);
        }
    }

    @Override
    public ResultDTO selectPermissionById(Integer id) {
        Permission returnPermission = permissionMapper.selectPermissionById(id);
        if(null == returnPermission){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据主键ID查找权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据主键ID查找权限成功",returnPermission);
        }
    }

    @Override
    public ResultDTO selectPermissionByPermName(String permname) {
        Permission returnPermission = permissionMapper.selectPermissionByPermName(permname);
        if(null == returnPermission){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据权限ID查找权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据权限ID查找权限成功",returnPermission);
        }
    }

    @Override
    public ResultDTO deletePermissionById(Integer id) {
        int returnNumber = permissionMapper.deletePermissionById(id);
        if(returnNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据主键ID删除权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据主键ID删除权限成功");
        }
    }

    @Override
    public ResultDTO deletePermissionByPermName(String permname) {
        int returnNumber = permissionMapper.deletePermissionByPermName(permname);
        if(returnNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据权限ID删除权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据权限ID删除权限成功");
        }
    }

    @Override
    public ResultDTO insertPermissionSelective(Permission permission) {
        int returnNumber = permissionMapper.insertPermissionSelective(permission);
        if(returnNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"新增权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"新增权限成功");
        }
    }

    @Override
    public ResultDTO updatePermissionByIdSelective(Permission permission) {
        int returnNumber = permissionMapper.updatePermissionByIdSelective(permission);
        if(returnNumber<=0){
            return new ResultDTO(HttpCode.FAIL.getCode(),"根据主键ID更新权限失败");
        }else{
            return new ResultDTO(HttpCode.SUCCESS.getCode(),"根据主键ID更新权限成功");
        }
    }

}
