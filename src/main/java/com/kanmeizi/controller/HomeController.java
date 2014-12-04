package com.kanmeizi.controller;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        modelAndView.addObject("photos", photoRepository.findOrderByPostDateDesc());
        modelAndView.setViewName("/index");
        return modelAndView;
    }


    @RequestMapping("/test")
    @ResponseBody
    public Object testV1(){
        List<Photo> photoList = photoRepository.findOrderByPostDateDesc();
        return photoList;
    }
}
