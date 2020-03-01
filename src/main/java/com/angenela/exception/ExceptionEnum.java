package com.angenela.exception;

public enum ExceptionEnum {
    SERVER_ERROR("服务器异常",500);

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ExceptionEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
