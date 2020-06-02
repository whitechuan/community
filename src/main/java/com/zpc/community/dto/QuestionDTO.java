package com.zpc.community.dto;

import com.zpc.community.entity.User;
import lombok.Data;

/**
 * ClassName: QuesstionDTO
 * Package: com.zpc.community.dto
 * Description:
 *
 * @Date: 2020/5/24 12:02
 * @Author:zpc@qq.com
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;

    private User user;
}
