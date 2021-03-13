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
     * IO异常
     */
    IOEXCEPTION(2001,"IO异常"),

    /**
     *未知方法错误
     */
    NOSUCHMETHOD(2002,"未知方法越界"),

    /**
     * 数组越界异常
     */
    INDEXOUTOFBOUNDSu(2003,"数组越界"),

    /**
     * 400错误 网络信息读不到异常
     */
    HTTPMESSAGENOTREADABLE(2004,"400错误,网络信息读不到"),

    /**
     * 400错误 类型不匹配异常
     */
    TYPEMISMATCH(2005,"400错误,网络信息读不到"),

    /**
     * 400错误,丢失请求参数异常
     */
    MISSINGSERVLETREQUESTPARAMETER(2006,"400错误,丢失请求参数"),

    /**
     * 405错误,不支持的请求方法
     */
    HTTPREQUESTMETHODNOTSUPPORTED(2007,"405错误,不支持的请求方法"),

    /**
     * 406错误,媒体类型转化错误异常
     */
    HTTPMEDIATYPENOTACCEPTABLE(2008,"406错误,媒体类型转化错误"),

    /**
     * 500错误,运行异常
     */
    RUN500(2009,"500错误,运行异常"),

    /**
     * 堆栈溢出异常
     */
    STACKOVERFLOW(2010,"堆栈溢出"),

    /**
     * 算术错误异常
     */
    ARITHMETIC(2011,"算数异常"),

    /**
     * 其他异常
     */
    OTHER(2012,"其他异常"),

    /**
     * 数据库查询为空异常
     */
    DATABASEISNULL(2013,"数据库查询为空"),

    /**
     * 用户名重复
     */
    DUPLICATEUSERNAME(2014,"用户名重复"),

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

    public String getMsg(){
        return msg;
    }
}
