package com.kanmeizi.controller;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by liuzhengyang on 2014/11/25.
 */

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    // 默认首页
    @RequestMapping(value = {""})
    public ModelAndView index(){
        return new ModelAndView("/index", "photos", photoRepository.findOrderByPostDateDesc());
    }

}
