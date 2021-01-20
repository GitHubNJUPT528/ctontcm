package com.cton.enums;

public enum UserTypeEnum {

    /**
     * 学生枚举值
     */
    STUDENT(1,"司机"),
    /**
     * 教师枚举值
     */
    TEACHER (2,"公司"),
    /**
     * 图书管理员枚举值
     */
    LIB_ADMIN(3,"管理员"),
    /**
     * 系统管理员枚举值
     */
    SYS_ADMIN(4,"系统管理员");

    private int num;

    private String name;

    UserTypeEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
