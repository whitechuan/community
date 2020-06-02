package com.zpc.community.dto;

import lombok.Data;

/**
 * ClassName: CommentDTO
 * Package: com.zpc.community.dto
 * Description:
 *
 * @Date: 2020/5/29 13:30
 * @Author:zpc@qq.com
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
