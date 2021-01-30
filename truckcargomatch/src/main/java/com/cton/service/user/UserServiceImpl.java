package com.cton.service.user;

import com.cton.mapper.UserMapper;
import com.cton.model.Role;
import com.cton.model.User;
import com.cton.utils.PageBean;
import com.cton.utils.SaltUtils;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Integer selectUserIdByUserName(String username) {
          return userMapper.selectUserIdByUserName(username);

//        Integer returnNumber = userMapper.selectUserIdByUserName(username);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户名查找用户ID失败");
//        }else{
//            return ResultUtil.success("根据用户名查找用户ID成功",returnNumber);
//        }

    }

    @Override
    public Integer insertUserSelective(User user){
        user.setCreateTime(new Date());
        return userMapper.insertUserSelective(user);
//        int returnNumber =  userMapper.insertUserSelective(user);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"新增用户失败");
//        }else{
//            return ResultUtil.success("新增用户成功");
//        }
    }

    @Override
    public List<User> listAllUsers() {
        List<User> userList = userMapper.listAllUsers();
        if (null!=userList)
            return userList;
        else
            return null;
    }

    @Override
    public PageBean<User> listAllUsersByKeyword(String keyword, Integer pageSize, Integer currentPage){
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userMapper.listAllUsersByKeyword(keyword);

        // 自定义分页信息
        int countNums = userList.size();     //总记录数
        PageBean<User> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(userList);
        return pageData;

    }


    @Override
    public Integer updateByUserIdSelective(User user){
        user.setUpdateTime(new Date());
        return userMapper.updateByUserIdSelective(user);
//        int returnNumber = userMapper.updateByUserIdSelective(user);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID更新用户失败");
//        }else{
//            return ResultUtil.success("根据用户ID更新用户成功");
//        }
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
//        User user = userMapper.selectUserById(id);
//        if(null == user){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID查找用户失败");
//        }else{
//            return ResultUtil.success("根据主键ID查找用户成功",user);
//        }
    }

    @Override
    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
//        User user = userMapper.selectUserByUserName(username);
//        if(null == user){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID查找用户失败");
//        }else{
//            return ResultUtil.success("根据用户ID查找用户成功",user);
//        }
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
//        int returnNumber = userMapper.deleteUserById(id);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据主键ID删除用户失败");
//        }else{
//            return ResultUtil.success("根据主键ID删除用户成功");
//        }
    }

    @Override
    public Integer deleteUserByUserName(String username) {
        return userMapper.deleteUserByUserName(username);
//        int returnNumber = userMapper.deleteUserByUserName(username);
//        if(returnNumber<=0){
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"根据用户ID删除用户失败");
//        }else{
//            return ResultUtil.success("根据用户ID删除用户成功");
//        }
    }

    @Override
    public Integer register(User user) {

        /**
         * 查询用户名是否重复
         */
        String registerUserName = user.getUsername();
        if(null != userMapper.selectUserIdByUserName(registerUserName))
//            return ResultUtil.error(HttpCode.FAIL.getCode(),"用户名重复");
            return -1;
        else{
            //处理业务调用Mapper
            //1.生成随机盐
            String salt = SaltUtils.getSalt(8);
            //2.将随机盐保存到数据
            user.setSalt(salt);
            //3.明文密码进行md5+salt+hash散列
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
            user.setPassword(md5Hash.toHex());
            userMapper.insertUserSelective(user);
//            return ResultUtil.success("注册成功");
            return 1;
        }
    }


}
