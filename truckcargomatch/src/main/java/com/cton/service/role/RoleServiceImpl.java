package com.cton.service.role;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.mapper.RoleMapper;
import com.cton.model.Role;
import com.cton.utils.ResultUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResultDTO selectRoleNameByRoleId(Integer roleId) {

        String returnString = roleMapper.selectRoleNameByRoleId(roleId);
        if(StringUtils.isNullOrEmpty(returnString)){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色名失败");
        }else{
            return ResultUtil.success("根据角色ID查找角色名成功",returnString);
        }
    }

    @Override
    public ResultDTO deleteRoleAllPermsByRoleId(Integer roleId){
        int returnNumber = roleMapper.deleteRoleAllPermsByRoleId(roleId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID删除角色所有权限失败");
        }else{
            return ResultUtil.success("根据角色ID删除角色所有权限成功");
        }

    }

    @Override
    public ResultDTO deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId){
        int returnNumber = roleMapper.deleteRolePermByPermIdAndRoleId(permId,roleId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID和权限ID删除角色对应权限失败");
        }else{
            return ResultUtil.success("根据角色ID和权限ID删除角色对应权限成功");
        }
    }

    @Override
    public ResultDTO deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId){
        int returnNumber = roleMapper.deleteRoleUserByUserIdAndRoleId(userId,roleId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID和用户ID删除用户对应角色失败");
        }else{
            return ResultUtil.success("根据角色ID和用户ID删除用户对应角色成功");
        }


    }

    @Override
    public ResultDTO selectPermsIdsByRoleId(Integer roleId){

        List returnList = roleMapper.selectPermsIdsByRoleId(roleId);
        if(null == returnList){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色所有权限失败");
        }else{
            return ResultUtil.success("根据角色ID查找角色所有权限成功",returnList);
        }
    }

    @Override
    public ResultDTO saveRolePerms(Integer roleId, Integer permId){

        int returnNumber = roleMapper.saveRolePerms(roleId,permId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"保存角色对应权限失败");
        }else{
            return ResultUtil.success("保存角色对应权限成功");
        }
    }

    @Override
    public ResultDTO deleteUserAllRolesByUserId(Integer userId){

        int returnNumber = roleMapper.deleteUserAllRolesByUserId(userId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID删除用户所有角色失败");
        }else{
            return ResultUtil.success("根据用户ID删除用户所有角色成功");
        }
    }

    @Override
    public ResultDTO selectUserAllRolesByUserId(Integer userId){

        List returnList = roleMapper.selectUserAllRolesByUserId(userId);
        if(null == returnList){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID查找用户所有角色失败");
        }else{
            return ResultUtil.success("根据用户ID查找用户所有角色成功",returnList);
        }
    }

    @Override
    public ResultDTO insertUserRole(Integer userId, Integer roleId){

        int returnNumber = roleMapper.insertUserRole(userId,roleId);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增用户对应角色失败");
        }else{
            return ResultUtil.success("新增用户对应角色成功");
        }
    }

    @Override
    public ResultDTO selectRoleById(Integer id) {
        Role returnRole = roleMapper.selectRoleById(id);
        if(null == returnRole){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID查找角色失败");
        }else{
            return ResultUtil.success("根据主键ID查找角色成功",returnRole);
        }
    }

    @Override
    public ResultDTO selectRoleByRoleName(String rolename) {
        Role returnRole = roleMapper.selectRoleByRoleName(rolename);
        if(null == returnRole){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色失败");
        }else{
            return ResultUtil.success("根据角色ID查找角色成功",returnRole);
        }
    }

    @Override
    public ResultDTO deleteRoleById(Integer id) {
        int returnNumber = roleMapper.deleteRoleById(id);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID删除角色失败");
        }else{
            return ResultUtil.success("根据主键ID删除角色成功");
        }
    }

    @Override
    public ResultDTO deleteRoleByRoleName(String rolename) {
        int returnNumber = roleMapper.deleteRoleByRoleName(rolename);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID删除角色失败");
        }else{
            return ResultUtil.success("根据角色ID删除角色成功");
        }
    }

    @Override
    public ResultDTO insertRoleSelective(Role role) {
        int returnNumber = roleMapper.insertRoleSelective(role);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增角色失败");
        }else{
            return ResultUtil.success("新增角色成功");
        }
    }

    @Override
    public ResultDTO updateRoleByIdSelective(Role role) {
        int returnNumber = roleMapper.updateRoleByIdSelective(role);
        if(returnNumber<=0){
            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID更新角色失败");
        }else{
            return ResultUtil.success("根据主键ID更新角色成功");
        }
    }


}
