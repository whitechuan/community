package com.zpc.community.advice;

import com.zpc.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: CustomizeExceptionHandler
 * Package: com.zpc.community.advice
 * Description:
 *
 * @Date: 2020/5/28 18:53
 * @Author:zpc@qq.com
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e, Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());

        }else {
        model.addAttribute("message", "服务冒烟呀了，要不等等在试一试！！");
        }
        return new ModelAndView("error");
    }

}
