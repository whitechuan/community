package com.zpc.community.mapper;

import com.zpc.community.entity.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: QuesstionMapper
 * Package: com.zpc.community.mapper
 * Description:
 *
 * @Date: 2020/5/21 17:55
 * @Author:zpc@qq.com
 */
@Mapper
public interface QuesstionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator})")
    public void create(Quesstion quesstion);

}
