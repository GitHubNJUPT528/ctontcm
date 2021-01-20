package com.cton.Realms;

import com.cton.mapper.PermissionMapper;
import com.cton.mapper.RoleMapper;
import com.cton.mapper.UserMapper;
import com.cton.model.User;
import com.cton.shiro.MyByteSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        //根据主身份信息获取角色和权限信息

        System.out.println("进入了授权");

        Integer userId = userMapper.selectUserIdByUserName(primaryPrincipal);
        System.out.println("userid："+userId);
        List roleIds = roleMapper.selectUserAllRolesByUserId(userId);
        System.out.println("roleids："+roleIds);

        //授权角色信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (!CollectionUtils.isEmpty(roleIds)){
            roleIds.forEach(roleId -> {
                simpleAuthorizationInfo.addRole(roleMapper.selectRoleNameByRoleId((Integer) roleId));
                //权限信息
                List permIds = roleMapper.selectPermsIdsByRoleId((Integer) roleId);
                if (!CollectionUtils.isEmpty(permIds)){
                    permIds.forEach(permId -> {
                        simpleAuthorizationInfo.addStringPermission(permissionMapper.selectPermNameByPermId((Integer) permId));
                    });
                }
            });


        }
            return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //在token中获取用户名
        String principal = (String) authenticationToken.getPrincipal();
        //根据身份信息使用jdbc mybatis查询相关数据库
        User user = userMapper.selectUserByUserName(principal);
        if (!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),new MyByteSource(user.getSalt()), this.getName());
        }


        return null;
    }
}
