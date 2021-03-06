package com.cton.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * u_user
 * @author
 */
@Data
@ApiModel(value = "User对象",description = "用户对象") //需要注意必须在controller中关联实体类 才能在文档中显示
public class User extends UserKey implements Serializable {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 年龄：1男2女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户状态：1有效; 2删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private String tmp2;

    private static final long serialVersionUID = 1L;
}
