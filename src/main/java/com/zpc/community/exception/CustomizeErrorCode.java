package com.zpc.community.exception;

/**
 * ClassName: CustomizeError
 * Package: com.zpc.community.exception
 * Description:
 *
 * @Date: 2020/5/29 10:05
 * @Author:zpc@qq.com
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不存在，要不要换个试试！"),
    TARGET_PARAM_NOT_FOUND(2002,"未选择任何问题或评论进行回复！"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试！！"),
    SYS_ERROR(2004,"服务冒烟呀了，要不等等在试一试！！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"你回复的评论不存在，要不要换个试试！")

    ;
    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}
