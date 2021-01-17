package com.cton.service.user;

import com.cton.mapper.UserMapper;
import com.cton.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int selectUserIdByUserName(String username) {

        return userMapper.selectUserIdByUserName(username);
    }

    @Override
    public int insertUserSelective(User user){

        return userMapper.insertUserSelective(user);
    }


    @Override
    public int updateByUserIdSelective(User user){
        return userMapper.updateByUserIdSelective(user);
    }

    @Override
    public User selectUserById(Integer id) {

        return userMapper.selectUserById(id);
    }

    @Override
    public User selectUserByUserId(Integer userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public int deleteUserById(Integer id) {

        return userMapper.deleteUserById(id);
    }

    @Override
    public int deleteUserByUserId(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }


}
