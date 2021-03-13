package com.cton.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * u_permission
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Permission对象",description = "权限对象") //需要注意必须在controller中关联实体类 才能在文档中显示
public class Permission implements Serializable {
    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    private Integer id;


    /**
     * 权限名称
     */
    @ApiModelProperty("权限名")
    private String permname;

    /**
     * 权限描述
     */
    @ApiModelProperty("权限描述")
    private String description;

    /**
     * 权限访问路径
     */
    @ApiModelProperty("权限访问路径")
    private String url;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String perms;

    /**
     * 父级权限id
     */
    @ApiModelProperty("父级权限id")
    private Integer parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @ApiModelProperty("类型   0：目录   1：菜单   2：按钮")
    private Integer type;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 状态：1有效；2删除
     */
    @ApiModelProperty("状态 1有效2删除")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("序列ID")
    private static final long serialVersionUID = 1L;
}
