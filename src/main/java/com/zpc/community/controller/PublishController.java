package com.zpc.community.controller;

import com.zpc.community.dto.QuestionDTO;
import com.zpc.community.entity.Question;
import com.zpc.community.entity.User;
import com.zpc.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: PublishController
 * Package: com.zpc.community.controller
 * Description:
 *
 * @Date: 2020/5/21 16:53
 * @Author:zpc@qq.com
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model){
        QuestionDTO quesstion = questionService.getById(id);
        model.addAttribute("title", quesstion.getTitle());
        model.addAttribute("description", quesstion.getDescription());
        model.addAttribute("tag", quesstion.getTag());
        model.addAttribute("id", quesstion.getId());
         return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value ="description",required = false) String description,
            @RequestParam(value ="tag",required = false) String tag,
            @RequestParam(value ="id") Integer id,
            HttpServletRequest request,
            Model model
    ){
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == ""){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error", "描述不能为空");
            return "publish";
        }
        User user =(User) request.getSession().getAttribute("user");
        if (user == null){
            model.addAttribute("error", "用户未登录!");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/index";
    }
}
