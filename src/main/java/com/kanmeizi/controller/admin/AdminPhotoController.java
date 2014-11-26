package com.kanmeizi.controller.admin;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
@RequestMapping("/admin")
@Controller
public class AdminPhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @RequestMapping("/photoList")
    public ModelAndView photoList(){
        return new ModelAndView("admin/photoList", "photos", photoRepository.findAll());
    }

    // 新增页面
    @RequestMapping("/add")
    public ModelAndView edit(){
        return new ModelAndView("/admin/photoAdd");
    }

    // 保存
    @RequestMapping("/save")
    public ModelAndView save(Photo photo){
        photo.setPostDate(new Date());
        System.out.println(photo);
        photoRepository.save(photo);
        return new ModelAndView("redirect:/admin/photoList");
    }
}
