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
    QUESTION_NOT_FOUND("你找的问题不存在，要不要换个试试！");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
     @Override
    public String getMessage() {
        return message;
    }
}
