package com.zpc.community.dto;

import lombok.Data;

/**
 * ClassName: AccesstokenDTO
 * Package: com.zpc.community.dto
 * Description:
 *
 * @Date: 2020/5/12 21:23
 * @Author:zpc@qq.com
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private  String redirect_uri;
    private  String state;


}
