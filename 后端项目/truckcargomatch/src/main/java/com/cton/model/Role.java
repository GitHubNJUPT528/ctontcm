package com.cton.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * u_role
 * @author 
 */
@Data
public class Role implements Serializable {
    private Integer id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态：1有效；2删除
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

    private static final long serialVersionUID = 1L;
}