package com.cton.enums;

public enum HttpCode {

    /**
     * 成功且有数据
     */
    SUCCESS(1001,"成功"),

    /**
     * 失败无数据
     */
    FAIL(1002,"失败"),

    /**
     * 系统异常
     */
    EXCEPTION(500,"系统异常");

    private int code;

    private String msg;

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

}
