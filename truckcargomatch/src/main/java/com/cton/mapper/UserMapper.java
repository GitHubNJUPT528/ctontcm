package com.cton.mapper;

import com.cton.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int selectUserIdByUserName(String username);

    int insertUserSelective(User user);

    int updateByUserIdSelective(User user);

    User selectUserById(Integer id);

    User selectUserByUserId(Integer userId);

    int deleteUserById(Integer id);

    int deleteUserByUserId(Integer userId);

}
