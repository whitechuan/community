package com.zpc.community.dto;

import com.zpc.community.exception.CustomizeErrorCode;
import com.zpc.community.exception.CustomizeException;
import lombok.Data;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: ResultDTO
 * Package: com.zpc.community.dto
 * Description:
 *
 * @Date: 2020/6/1 10:52
 * @Author:zpc@qq.com
 */
@Data
public class ResultDTO {
    private Integer code;
    private String mesage;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMesage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMesage("请求成功！");
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }
}
