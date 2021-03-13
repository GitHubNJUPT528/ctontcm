package com.cton.common;

import com.cton.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "活跃用户",description = "活跃用户对象")
public class ActiverUser {

    @ApiModelProperty("用户")
    private User user;

    @ApiModelProperty("角色")
    private List<String> roles;

    @ApiModelProperty("权限")
    private List<String> permissions;
}


