package com.yz.jcs.util;


public enum ResultEnum {

    SERVER_ERROR(-1, "系统异常"),
    SUCCESS(1, "成功"),
    NO_ACCESS(301, "无此权限"),
    UNLOGIN(302, "未登录"),
    UNFOLLOW(303, "请先关注云享付公众号"),
    PARAM_ERROR(400, "参数异常"),
    CENTER_ERROR(510, "中心异常"),
    SESSION_ERROR(710, "session异常"),
    ;
    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
