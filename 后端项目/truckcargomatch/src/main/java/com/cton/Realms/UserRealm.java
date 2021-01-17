package com.cton.Realms;

import com.cton.mapper.RoleMapper;
import com.cton.model.User;
import com.cton.service.perms.PermsService;
import com.cton.service.user.UserService;
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
    private UserService userService;

    @Autowired
    private PermsService permsService;

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

        Integer userId = userService.selectUserIdByUserName(primaryPrincipal);
        List roleIds = roleMapper.selectUserAllRolesByUserId(userId);

        //授权角色信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (!CollectionUtils.isEmpty(roleIds)){
            roleIds.forEach(roleId -> {
                simpleAuthorizationInfo.addRole(roleMapper.selectRoleNameByRoleId((Integer) roleId));
                //权限信息
                List permIds = roleMapper.selectPermsIdsByRoleId((Integer) roleId);
                if (!CollectionUtils.isEmpty(permIds)){
                    permIds.forEach(permId -> {
                        simpleAuthorizationInfo.addStringPermission(permsService.selectPermNameByPermId((Integer) permId));
                    });
                }
            });


        }
            return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("进入了认证");
        //在token中获取用户名
        String principal = (String) authenticationToken.getPrincipal();
        //根据身份信息使用jdbc mybatis查询相关数据库
        int userId = userService.selectUserIdByUserName(principal);
        User user = userService.selectUserByUserId(userId);
        if (!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),new MyByteSource(user.getSalt()), this.getName());
        }


        return null;
    }
}
