package com.cton.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * u_permission
 * @author
 */
@Data
public class Permission implements Serializable {
    private Integer id;


    /**
     * 权限名称
     */
    private String permname;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限访问路径
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 父级权限id
     */
    private Integer parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态：1有效；2删除
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
