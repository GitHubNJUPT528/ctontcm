package com.cton.service.role;

import com.cton.constants.ResultDTO;
import com.cton.model.Role;
import com.cton.utils.PageBean;
import io.swagger.models.auth.In;

import java.util.List;

public interface RoleService {
    Integer createRole(Role role);

    Integer updateRoleByIdSelective(Role role);

    List<Role> listAllRoles();

    PageBean<Role> listAllRolesByKeyword(String keyword, Integer pageSize, Integer currentPage);

    String selectRoleNameByRoleId(Integer roleId);

    Integer deleteRoleAllPermsByRoleId(Integer roleId);

    Integer deleteRolePermByPermIdAndRoleId(Integer permId,Integer roleId);

    Integer deleteRoleUserByUserIdAndRoleId(Integer userId,Integer roleId);

    List<Integer> selectPermsIdsByRoleId(Integer roleId);

    Integer saveRolePerms(Integer roleId, Integer permId);

    Integer deleteUserAllRolesByUserId(Integer userId);

    List<Integer> selectUserAllRolesByUserId(Integer userId);

    Integer insertUserRole(Integer userId, Integer roleId);

    Role selectRoleById(Integer id);

    Role selectRoleByRoleName(String rolename);

    Integer deleteRoleById(Integer id);

    Integer deleteRoleByRoleName(String rolename);

    Integer deleteBatch(List<Integer> roleIds);

    Integer allocPermission(Integer roleId, List<Integer> permissionIds);

}
