package com.cton.service.user;

import com.cton.constants.ResultDTO;
import com.cton.model.Role;
import com.cton.model.User;
import com.cton.utils.PageBean;

import java.util.List;

public interface UserService {
    Integer selectUserIdByUserName(String username);

    Integer insertUserSelective(User user);

    Integer updateByUserIdSelective(User user);

    User selectUserById(Integer id);

    User selectUserByUserName(String username);

    Integer deleteUserById(Integer id);

    Integer deleteUserByUserName(String username);

    //注册用户
    Integer register(User user);

    List<User> listAllUsers();

    PageBean<User> listAllUsersByKeyword(String keyword, Integer pageSize, Integer currentPage);

}
