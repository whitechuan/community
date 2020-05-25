package com.zpc.community.entity;

import lombok.Data;

/**
 * ClassName: User
 * Package: com.zpc.community.entity
 * Description:
 *
 * @Date: 2020/5/20 21:26
 * @Author:zpc@qq.com
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
