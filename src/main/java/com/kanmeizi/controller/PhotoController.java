package com.kanmeizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuzhengyang on 2014/11/25.
 */

@Controller
@RequestMapping("/photo")
public class PhotoController {

    // 默认首页
    @RequestMapping(value = {""})
    public ModelAndView index(){
        return new ModelAndView("/index");
    }
}
