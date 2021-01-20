package com.cton.mapper;

import com.cton.model.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {
    String selectPermNameByPermId(Integer permId);

    Permission selectPermissionById(Integer id);

    Permission selectPermissionByPermName(String permname);

    Integer deletePermissionById(Integer id);

    Integer deletePermissionByPermName(String permName);

    Integer insertPermissionSelective(Permission permission);

    Integer updatePermissionByIdSelective(Permission permission);
}
