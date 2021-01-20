package com.cton.mapper;

import com.cton.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    String selectRoleNameByRoleId(Integer roleId);

    Integer deleteRoleAllPermsByRoleId(Integer roleId);

    Integer deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId);

    Integer deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId);

    List selectPermsIdsByRoleId(Integer roleId);

    Integer saveRolePerms(Integer roleId, Integer permId);

    Integer deleteUserAllRolesByUserId(Integer userId);

    List selectUserAllRolesByUserId(Integer userId);

    Integer insertUserRole(Integer userId, Integer roleId);

    Role selectRoleById(Integer id);

    Role selectRoleByRoleName(String rolename);

    Integer deleteRoleById(Integer id);

    Integer deleteRoleByRoleName(String rolename);

    Integer insertRoleSelective(Role role);

    Integer updateRoleByIdSelective(Role role);

}
