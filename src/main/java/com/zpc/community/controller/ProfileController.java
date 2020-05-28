package com.zpc.community.controller;

import com.zpc.community.dto.PaginationDTO;
import com.zpc.community.entity.User;
import com.zpc.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ProfileController
 * Package: com.zpc.community.controller
 * Description:
 *
 * @Date: 2020/5/26 11:52
 * @Author:zpc@qq.com
 */
@Controller
public class ProfileController {
    @Autowired
    private QuestionService quesstionServic;
    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable(name = "action") String action,
            Model model,
            @RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name = "size",defaultValue = "3") Integer size,
            HttpServletRequest request
    ) {
        User user =(User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/index";
        }
            if ("questions".equals(action)) {
                model.addAttribute("section", "questions");
                model.addAttribute("sectionName", "我的提问");

            } else if ("replies".equals(action)) {
                model.addAttribute("section", "replies");
                model.addAttribute("sectionName", "最新回复");
            }

        PaginationDTO paginationDTO = quesstionServic.quesstionList(user.getId(), page, size);
        model.addAttribute("paginationDTO", paginationDTO);
            return "profile";
        }
    }
