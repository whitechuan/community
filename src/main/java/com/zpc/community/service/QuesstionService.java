package com.zpc.community.service;

import com.zpc.community.dto.PaginationDTO;
import com.zpc.community.dto.QuesstionDTO;
import com.zpc.community.entity.Quesstion;
import com.zpc.community.entity.User;
import com.zpc.community.mapper.QuesstionMapper;
import com.zpc.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: QuesstionService
 * Package: com.zpc.community.service
 * Description:
 *
 * @Date: 2020/5/24 12:04
 * @Author:zpc@qq.com
 */
@Service
public class QuesstionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuesstionMapper quesstionMapper;

    public PaginationDTO quesstionList(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = quesstionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Quesstion> quesstionList = quesstionMapper.quesstionList(offset, size);
        List<QuesstionDTO> quesstionDTOList = new ArrayList<>();

        for (Quesstion quesstion : quesstionList) {
            User user = userMapper.fintByID(quesstion.getCreator());
            QuesstionDTO quesstionDTO = new QuesstionDTO();
            BeanUtils.copyProperties(quesstion, quesstionDTO);
            quesstionDTO.setUser(user);
            quesstionDTOList.add(quesstionDTO);
        }
        paginationDTO.setQuesstions(quesstionDTOList);

        return paginationDTO;
    }
}
