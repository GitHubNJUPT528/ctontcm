package com.cton.constants;

import lombok.Data;

/**
 * 基本返回数据结构
 */
@Data
public class ResultDTO {
    private String system;

    private int code;

    private String msg;

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
