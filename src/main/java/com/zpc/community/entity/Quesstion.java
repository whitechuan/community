package com.zpc.community.entity;

import lombok.Data;

/**
 * ClassName: Quesstion
 * Package: com.zpc.community.entity
 * Description:
 *
 * @Date: 2020/5/21 18:00
 * @Author:zpc@qq.com
 */
@Data
public class Quesstion {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;

}