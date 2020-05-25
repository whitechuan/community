package com.zpc.community.controller;

import com.zpc.community.entity.Quesstion;
import com.zpc.community.entity.User;
import com.zpc.community.mapper.QuesstionMapper;
import com.zpc.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
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
    private QuesstionMapper quesstionMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
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
        User user =null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length !=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if (user == null){
            model.addAttribute("error", "用户未登录!");
            return "publish";
        }
        Quesstion quesstion = new Quesstion();
        quesstion.setTitle(title);
        quesstion.setDescription(description);
        quesstion.setTag(tag);
        quesstion.setCreator(user.getId());
        quesstion.setGmtCreate(System.currentTimeMillis());
        quesstion.setGmtModified(quesstion.getGmtCreate());

        quesstionMapper.create(quesstion);
        return "redirect:/index";
    }
}
