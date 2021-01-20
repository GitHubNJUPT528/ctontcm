package com.cton.service.perms;

import com.cton.constants.ResultDTO;
import com.cton.model.Permission;

import java.util.List;

public interface PermsService {

    ResultDTO selectPermNameByPermId(Integer permId);

    ResultDTO selectPermissionById(Integer id);

    ResultDTO selectPermissionByPermName(String permname);

    ResultDTO deletePermissionById(Integer id);

    ResultDTO deletePermissionByPermName(String permname);

    ResultDTO insertPermissionSelective(Permission permission);

    ResultDTO updatePermissionByIdSelective(Permission permission);

}
