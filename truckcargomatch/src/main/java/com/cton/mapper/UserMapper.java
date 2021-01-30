package com.cton.mapper;

import com.cton.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> listAllUsers();

    List<User> listAllUsersByKeyword(String keyword);

    Integer selectUserIdByUserName(String username);

    Integer insertUserSelective(User user);

    Integer updateByUserIdSelective(User user);

    User selectUserById(Integer id);

    User selectUserByUserName(String username);

    Integer deleteUserById(Integer id);

    Integer deleteUserByUserName(String username);

}
