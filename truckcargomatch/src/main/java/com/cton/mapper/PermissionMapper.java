package com.cton.mapper;

import com.cton.model.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {
    String selectPermNameByPermId(Integer permId);

    Permission selectPermissionById(Integer id);

    Permission selectPermissionByPermId(Integer permId);

    int deletePermissionById(Integer id);

    int deletePermissionByPermId(Integer permId);

    int insertPermissionSelective(Permission permission);

    int updatePermissionByIdSelective(Permission permission);
}
