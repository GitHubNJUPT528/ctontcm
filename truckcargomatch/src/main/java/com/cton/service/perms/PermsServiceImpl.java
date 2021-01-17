package com.cton.service.perms;

import com.cton.mapper.PermissionMapper;
import com.cton.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermsServiceImpl implements PermsService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public String selectPermNameByPermId(Integer permId){

        return permissionMapper.selectPermNameByPermId(permId);
    }

    @Override
    public Permission selectPermissionById(Integer id) {
        return permissionMapper.selectPermissionById(id);
    }

    @Override
    public Permission selectPermissionByPermId(Integer permId) {
        return permissionMapper.selectPermissionByPermId(permId);
    }

    @Override
    public int deletePermissionById(Integer id) {
        return permissionMapper.deletePermissionById(id);
    }

    @Override
    public int deletePermissionByPermId(Integer permId) {
        return permissionMapper.deletePermissionByPermId(permId);
    }

    @Override
    public int insertPermissionSelective(Permission permission) {
        return permissionMapper.insertPermissionSelective(permission);
    }

    @Override
    public int updatePermissionByIdSelective(Permission permission) {
        return permissionMapper.updatePermissionByIdSelective(permission);
    }

}
