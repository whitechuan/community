package com.zpc.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: HelloController
 * Package: com.zpc.community.controller
 * Description:
 *
 * @Date: 2020/5/12 17:51
 * @Author:zpc@qq.com
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name, Model model){

        model.addAttribute("name", name);
        return "hello";
    }
}
