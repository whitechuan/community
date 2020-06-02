package com.zpc.community.exception;

/**
 * ClassName: CustomizeException
 * Package: com.zpc.community.exception
 * Description:
 *
 * @Date: 2020/5/29 9:50
 * @Author:zpc@qq.com
 */
public class CustomizeException extends RuntimeException {
    private   String message;
    private  Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
    public Integer getCode() {
        return code;
    }
}
