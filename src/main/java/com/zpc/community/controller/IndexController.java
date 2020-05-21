package com.zpc.community.controller;

import com.zpc.community.entity.User;
import com.zpc.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
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
    private UserMapper userMapper;

    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        return "index";
    }
}
