package com.cton.service.perms;

import com.cton.model.Permission;

import java.util.List;

public interface PermsService {

    String selectPermNameByPermId(Integer permId);

    Permission selectPermissionById(Integer id);

    Permission selectPermissionByPermId(Integer permId);

    int deletePermissionById(Integer id);

    int deletePermissionByPermId(Integer permId);

    int insertPermissionSelective(Permission permission);

    int updatePermissionByIdSelective(Permission permission);

}
