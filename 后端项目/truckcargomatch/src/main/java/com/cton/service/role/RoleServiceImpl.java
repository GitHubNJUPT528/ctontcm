package com.cton.service.role;

import com.cton.mapper.RoleMapper;
import com.cton.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String selectRoleNameByRoleId(Integer roleId) {

        return roleMapper.selectRoleNameByRoleId(roleId);
    }

    @Override
    public int deleteRoleAllPermsByRoleId(Integer roleId){
        return roleMapper.deleteRoleAllPermsByRoleId(roleId);

    }

    @Override
    public int deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId){
        return roleMapper.deleteRolePermByPermIdAndRoleId(permId,roleId);
    }

    @Override
    public int deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId){
        return roleMapper.deleteRoleUserByUserIdAndRoleId(userId,roleId);

    }

    @Override
    public List selectPermsIdsByRoleId(Integer roleId){

        return roleMapper.selectPermsIdsByRoleId(roleId);
    }

    @Override
    public int saveRolePerms(Integer roleId, Integer permId){

        return roleMapper.saveRolePerms(roleId,permId);
    }

    @Override
    public int deleteUserAllRolesByUserId(Integer userId){

        return roleMapper.deleteUserAllRolesByUserId(userId);
    }

    @Override
    public List selectUserAllRolesByUserId(Integer userId){

        return roleMapper.selectUserAllRolesByUserId(userId);
    }

    @Override
    public int insertUserRole(Integer userId, Integer roleId){

        return roleMapper.insertUserRole(userId,roleId);
    }

    @Override
    public Role selectRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
    }

    @Override
    public Role selectRoleByRoleId(Integer roleId) {
        return roleMapper.selectRoleByRoleId(roleId);
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public int deleteRoleByRoleId(Integer roleId) {
        return roleMapper.deleteRoleByRoleId(roleId);
    }

    @Override
    public int insertRoleSelective(Role role) {
        return roleMapper.insertRoleSelective(role);
    }

    @Override
    public int updateRoleByIdSelective(Role role) {
        return roleMapper.updateRoleByIdSelective(role);
    }


}
