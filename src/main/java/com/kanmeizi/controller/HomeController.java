package com.kanmeizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 * Created by liuzhengyang on 2014/11/25.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"", "/", "/home"})
    public ModelAndView home(){
        return new ModelAndView("/index");
    }
}
