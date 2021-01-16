package com.cton.service.role;

import com.cton.model.Role;

import java.util.List;

public interface RoleService {

    String selectRoleNameByRoleId(Integer roleId);

    int deleteRoleAllPermsByRoleId(Integer roleId);

    int deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId);

    int deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId);

    List selectPermsIdsByRoleId(Integer roleId);

    int saveRolePerms(Integer roleId, Integer permId);

    int deleteUserAllRolesByUserId(Integer userId);

    List selectUserAllRolesByUserId(Integer userId);

    int insertUserRole(Integer userId, Integer roleId);

    Role selectRoleById(Integer id);

    Role selectRoleByRoleId(Integer roleId);

    int deleteRoleById(Integer id);

    int deleteRoleByRoleId(Integer roleId);

    int insertRoleSelective(Role role);

    int updateRoleByIdSelective(Role role);


}
