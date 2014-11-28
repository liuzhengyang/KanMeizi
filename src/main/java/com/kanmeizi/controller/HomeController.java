package com.kanmeizi.controller;

import com.kanmeizi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 * Created by liuzhengyang on 2014/11/25.
 */
@Controller
public class HomeController {

    @Autowired
    private PhotoRepository photoRepository;

    @RequestMapping(value = {"", "/", "/home"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("photos", photoRepository.findAll());
        modelAndView.setViewName("/index");
        return modelAndView;
    }


    @RequestMapping("test")
    public ModelAndView testV1(){
        return new ModelAndView("/index");
    }
}
