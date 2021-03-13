package com.cton.constants;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基本返回数据结构
 */
@Data
@ApiModel(value = "ResultDTO对象",description = "统一返回格式对象")
public class ResultDTO {
    @ApiModelProperty("系统")
    private String system = "cton";

    @ApiModelProperty("代码")
    private int code;

    @ApiModelProperty("信息")
    private String msg;

    @ApiModelProperty("数据")
    private Object data;

    public ResultDTO(){};

    public ResultDTO(int code, String msg) {
        this.system="cton";
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(int code, String msg, Object data) {
        this.system="cton";
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
