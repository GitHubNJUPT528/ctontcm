package com.cton.mapper;

import com.cton.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> listAllPerms();

    List<Permission> listAllPermsByKeyword(Integer type, String nameKeyword,String urlKeyword);

    String selectPermNameByPermId(Integer permId);

    Permission selectPermissionById(Integer id);

    Permission selectPermissionByPermName(String permname);

    Integer deletePermissionById(Integer id);

    Integer deletePermissionByPermName(String permName);

    Integer insertPermissionSelective(Permission permission);

    Integer updatePermissionByIdSelective(Permission permission);
}
