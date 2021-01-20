package com.cton.service.user;

import com.cton.constants.ResultDTO;
import com.cton.model.User;

public interface UserService {
    ResultDTO selectUserIdByUserName(String username);

    ResultDTO insertUserSelective(User user);

    ResultDTO updateByUserIdSelective(User user);

    ResultDTO selectUserById(Integer id);

    ResultDTO selectUserByUserName(String username);

    ResultDTO deleteUserById(Integer id);

    ResultDTO deleteUserByUserName(String username);

    //注册用户
    ResultDTO register(User user);


}
