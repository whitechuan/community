package com.zpc.community.controller;

import com.zpc.community.dto.PaginationDTO;
import com.zpc.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: HelloController
 * Package: com.zpc.community.controller
 * Description:
 *
 * @Date: 2020/5/12 17:51
 * @Author:zpc@qq.com
 */
@Controller
public class IndexController {
    @Autowired
    private QuestionService quesstionServic;
    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "3") Integer size){

            PaginationDTO paginationDTO = quesstionServic.quesstionList(page, size);
            model.addAttribute("paginationDTO", paginationDTO);

            return "index";
    }
}
