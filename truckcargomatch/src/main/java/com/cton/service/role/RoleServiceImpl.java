package com.cton.service.role;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.mapper.RoleMapper;
import com.cton.mapper.UserMapper;
import com.cton.model.Role;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer createRole(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insertRoleSelective(role);
//        int returnNumber = roleMapper.insertRoleSelective(role);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增角色失败");
//        }else{
//            return ResultUtil.success("新增角色成功");
//        }
    }

    @Override
    public Integer updateRoleByIdSelective(Role role) {
        role.setUpdateTime(new Date());
        return roleMapper.updateRoleByIdSelective(role);
//        int returnNumber = roleMapper.updateRoleByIdSelective(role);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID更新角色失败");
//        }else{
//            return ResultUtil.success("根据主键ID更新角色成功");
//        }
    }

    @Override
    public List<Role> listAllRoles() {
        return roleMapper.listAllRoles();

    }

    @Override
    public PageBean<Role> listAllRolesByKeyword(String keyword, Integer pageSize, Integer currentPage){
        PageHelper.startPage(currentPage, pageSize);
        List<Role> roleList = roleMapper.listAllRolesByKeyword(keyword);

        // 自定义分页信息
        int countNums = roleList.size();     //总记录数
        PageBean<Role> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(roleList);
        return pageData;

    }

    @Override
    public String selectRoleNameByRoleId(Integer roleId) {
        return roleMapper.selectRoleNameByRoleId(roleId);
//        String returnString = roleMapper.selectRoleNameByRoleId(roleId);
//        if(StringUtils.isNullOrEmpty(returnString)){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色名失败");
//        }else{
//            return ResultUtil.success("根据角色ID查找角色名成功",returnString);
//        }
    }

    @Override
    public Integer deleteRoleAllPermsByRoleId(Integer roleId){
        return roleMapper.deleteRoleAllPermsByRoleId(roleId);
//        int returnNumber = roleMapper.deleteRoleAllPermsByRoleId(roleId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID删除角色所有权限失败");
//        }else{
//            return ResultUtil.success("根据角色ID删除角色所有权限成功");
//        }

    }

    @Override
    public Integer deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId){
        return roleMapper.deleteRolePermByPermIdAndRoleId(permId,roleId);
//        int returnNumber = roleMapper.deleteRolePermByPermIdAndRoleId(permId,roleId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID和权限ID删除角色对应权限失败");
//        }else{
//            return ResultUtil.success("根据角色ID和权限ID删除角色对应权限成功");
//        }
    }

    @Override
    public Integer deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId){
        return roleMapper.deleteRoleUserByUserIdAndRoleId(userId,roleId);
//        int returnNumber = roleMapper.deleteRoleUserByUserIdAndRoleId(userId,roleId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID和用户ID删除用户对应角色失败");
//        }else{
//            return ResultUtil.success("根据角色ID和用户ID删除用户对应角色成功");
//        }


    }

    @Override
    public List<Integer> selectPermsIdsByRoleId(Integer roleId){
        return roleMapper.selectPermsIdsByRoleId(roleId);
//        List returnList = roleMapper.selectPermsIdsByRoleId(roleId);
//        if(null == returnList){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色所有权限失败");
//        }else{
//            return ResultUtil.success("根据角色ID查找角色所有权限成功",returnList);
//        }
    }

    @Override
    public Integer saveRolePerms(Integer roleId, Integer permId){
        return roleMapper.saveRolePerms(roleId,permId);
//        int returnNumber = roleMapper.saveRolePerms(roleId,permId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"保存角色对应权限失败");
//        }else{
//            return ResultUtil.success("保存角色对应权限成功");
//        }
    }

    @Override
    public Integer deleteUserAllRolesByUserId(Integer userId){
        return roleMapper.deleteUserAllRolesByUserId(userId);
//        int returnNumber = roleMapper.deleteUserAllRolesByUserId(userId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID删除用户所有角色失败");
//        }else{
//            return ResultUtil.success("根据用户ID删除用户所有角色成功");
//        }
    }

    @Override
    public List<Integer> selectUserAllRolesByUserId(Integer userId){
        return roleMapper.selectUserAllRolesByUserId(userId);
//        List returnList = roleMapper.selectUserAllRolesByUserId(userId);
//        if(null == returnList){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID查找用户所有角色失败");
//        }else{
//            return ResultUtil.success("根据用户ID查找用户所有角色成功",returnList);
//        }
    }

    @Override
    public Integer insertUserRole(Integer userId, Integer roleId){
        return roleMapper.insertUserRole(userId,roleId);
//        int returnNumber = roleMapper.insertUserRole(userId,roleId);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增用户对应角色失败");
//        }else{
//            return ResultUtil.success("新增用户对应角色成功");
//        }
    }

    @Override
    public Role selectRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
//        Role returnRole = roleMapper.selectRoleById(id);
//        if(null == returnRole){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID查找角色失败");
//        }else{
//            return ResultUtil.success("根据主键ID查找角色成功",returnRole);
//        }
    }

    @Override
    public Role selectRoleByRoleName(String rolename) {
        return roleMapper.selectRoleByRoleName(rolename);
//        Role returnRole = roleMapper.selectRoleByRoleName(rolename);
//        if(null == returnRole){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID查找角色失败");
//        }else{
//            return ResultUtil.success("根据角色ID查找角色成功",returnRole);
//        }
    }

    @Override
    public Integer deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
//        int returnNumber = roleMapper.deleteRoleById(id);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID删除角色失败");
//        }else{
//            return ResultUtil.success("根据主键ID删除角色成功");
//        }
    }

    @Override
    public Integer deleteRoleByRoleName(String rolename) {
        return roleMapper.deleteRoleByRoleName(rolename);
//        int returnNumber = roleMapper.deleteRoleByRoleName(rolename);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据角色ID删除角色失败");
//        }else{
//            return ResultUtil.success("根据角色ID删除角色成功");
//        }
    }


    @Override
    @Transactional
    public Integer allocPermission(Integer roleId, List<Integer> permissionIds){
        for (Integer permissionId:permissionIds){
            Integer count = roleMapper.saveRolePerms(roleId,permissionId);
            if(count<=0)
                return count;
        }
        return 1;
    }

    @Override
    @Transactional
    public Integer deleteBatch(List<Integer> roleIds){
        for (Integer roleId:roleIds){
            Integer count = roleMapper.deleteRoleById(roleId);
            roleMapper.deleteRoleAllPermsByRoleId(roleId);
            if(count<=0)
                return count;
        }
        return 1;
    }

}
