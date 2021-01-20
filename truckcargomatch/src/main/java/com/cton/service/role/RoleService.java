package com.cton.service.role;

import com.cton.constants.ResultDTO;
import com.cton.model.Role;

import java.util.List;

public interface RoleService {

    ResultDTO selectRoleNameByRoleId(Integer roleId);

    ResultDTO deleteRoleAllPermsByRoleId(Integer roleId);

    ResultDTO deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId);

    ResultDTO deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId);

    ResultDTO selectPermsIdsByRoleId(Integer roleId);

    ResultDTO saveRolePerms(Integer roleId, Integer permId);

    ResultDTO deleteUserAllRolesByUserId(Integer userId);

    ResultDTO selectUserAllRolesByUserId(Integer userId);

    ResultDTO insertUserRole(Integer userId, Integer roleId);

    ResultDTO selectRoleById(Integer id);

    ResultDTO selectRoleByRoleName(String rolename);

    ResultDTO deleteRoleById(Integer id);

    ResultDTO deleteRoleByRoleName(String rolename);

    ResultDTO insertRoleSelective(Role role);

    ResultDTO updateRoleByIdSelective(Role role);


}
