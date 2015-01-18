package com.kanmeizi.controller;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by liuzhengyang on 2014/11/25.
 */

@Controller
@RequestMapping("/photo")
public class PhotoController {

    private static final Logger logger = Logger.getLogger(PhotoController.class);

    @Autowired
    private PhotoRepository photoRepository;

    // 默认首页
    @RequestMapping(value = {""})
    public ModelAndView index(){
        return new ModelAndView("/index", "photos", photoRepository.findOrderByPostDateDesc());
    }

    // 分页
    @RequestMapping("/page/{page}")
    public ModelAndView getPage(@PathVariable("page") int page){
        ModelAndView modelAndView = new ModelAndView();
        Page<Photo> pageObj = photoRepository.findAll(new PageRequest(page, 2));
        logger.info(pageObj);
        modelAndView.addObject("pages", pageObj.getContent());
        modelAndView.addObject("pageNumber", pageObj.getTotalPages());
        modelAndView.addObject("totalElements", pageObj.getTotalElements());
        modelAndView.setViewName("/pagination");
        return modelAndView;
    }


    @RequestMapping("findPage")
    @ResponseBody
    public List<Photo> findPage(String src, String title){
        return photoRepository.findBySrcContainingOrTitleContaining(src, title);
    }
}
