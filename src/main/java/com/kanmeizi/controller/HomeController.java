package com.kanmeizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuzhengyang on 2014/11/25.
 */
@RequestMapping("/")
@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("/index");
    }
}
