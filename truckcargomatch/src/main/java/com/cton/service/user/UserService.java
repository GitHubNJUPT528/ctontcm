package com.cton.service.user;

import com.cton.model.User;

public interface UserService {
    int selectUserIdByUserName(String username);

    int insertUserSelective(User user);

    int updateByUserIdSelective(User user);

    User selectUserById(Integer id);

    User selectUserByUserId(Integer userId);

    int deleteUserById(Integer id);

    int deleteUserByUserId(Integer userId);


}
