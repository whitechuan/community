package com.zpc.community.enums;

import org.apache.ibatis.type.IntegerTypeHandler;

/**
 * ClassName: CommentTypeEnum
 * Package: com.zpc.community.enums
 * Description:
 *
 * @Date: 2020/6/1 11:01
 * @Author:zpc@qq.com
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    public static boolean isExit(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }
}
