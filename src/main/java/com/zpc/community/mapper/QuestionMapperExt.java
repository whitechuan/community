package com.zpc.community.mapper;

import com.zpc.community.entity.Question;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: QuestionMapperExt
 * Package: com.zpc.community.mapper
 * Description:
 *
 * @Date: 2020/5/29 11:20
 * @Author:zpc@qq.com
 */
public interface QuestionMapperExt {
    int incView(@Param("record") Question record);
    int incCommentCount(@Param("record") Question record);
}
