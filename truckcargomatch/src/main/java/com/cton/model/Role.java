package com.cton.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * u_role
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role对象",description = "角色对象") //需要注意必须在controller中关联实体类 才能在文档中显示
public class Role implements Serializable {
    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名")
    private String rolename;

    /**
     * 角色描述
     */
    @ApiModelProperty("角色描述")
    private String description;

    /**
     * 状态：1有效；2删除
     */
    @ApiModelProperty("状态 1有效2删除")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("序列ID")
    private static final long serialVersionUID = 1L;
}
