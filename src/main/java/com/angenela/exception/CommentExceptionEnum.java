package com.angenela.exception;

public enum  CommentExceptionEnum {
    NAME_TOO_LONG(101,"名字太长啦！"),
    TEXT_TOO_LONG(102,"评论内容太长啦！"),
    QQ_TOO_LONG(103,"我怀疑你给的不是QQ号！"),

    TEXT_IS_NULL(201,"内容不能为空！");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CommentExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommentExceptionEnum getByCode(Integer code){
        CommentExceptionEnum[] enums = CommentExceptionEnum.values();
        for (CommentExceptionEnum anEnum : enums) {
            if(anEnum.code.equals(code)){
                return anEnum;
            }
        }
        return null;
    }
}
