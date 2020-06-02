package com.zpc.community.controller;

import com.zpc.community.dto.QuestionDTO;
import com.zpc.community.mapper.QuestionMapper;
import com.zpc.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: QuestionController
 * Package: com.zpc.community.controller
 * Description:
 *
 * @Date: 2020/5/27 17:52
 * @Author:zpc@qq.com
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(
            @PathVariable(name = "id") Long id,
            Model model
    ){
        QuestionDTO questionDTO = questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }

}
