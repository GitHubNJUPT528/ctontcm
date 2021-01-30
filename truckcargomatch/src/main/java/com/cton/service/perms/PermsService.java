package com.cton.service.perms;

import com.cton.constants.ResultDTO;
import com.cton.model.Permission;
import com.cton.utils.PageBean;

import java.util.List;

public interface PermsService {

    List<Permission> listAllPerms();

    PageBean<Permission> listAllPermsByKeyword(Integer type, String nameKeyword, String urlKeyword, Integer pageSize, Integer currentPage);

    String selectPermNameByPermId(Integer permId);

    Permission selectPermissionById(Integer id);

    Permission selectPermissionByPermName(String permname);

    Integer deletePermissionById(Integer id);

    Integer deletePermissionByPermName(String permname);

    Integer insertPermissionSelective(Permission permission);

    Integer updatePermissionByIdSelective(Permission permission);

}
