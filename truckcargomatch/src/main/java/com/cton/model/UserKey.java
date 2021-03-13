package com.cton.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * u_user
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserKey implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("序列ID")
    private static final long serialVersionUID = 1L;
}
