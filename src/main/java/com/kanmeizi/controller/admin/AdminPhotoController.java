package com.kanmeizi.controller.admin;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
@RequestMapping("/admin")
@Controller
public class AdminPhotoController {
    private Logger logger = Logger.getLogger(AdminPhotoController.class);

    @Autowired
    private PhotoRepository photoRepository;

    @RequestMapping("/photoList")
    public ModelAndView photoList(){
        return new ModelAndView("/admin/photoList", "photos", photoRepository.findAll());
    }

    // 新增页面
    @RequestMapping("/new")
    public ModelAndView edit(){
        return new ModelAndView("/admin/photoAdd");
    }

    // 更新
    @RequestMapping("/update")
    public ModelAndView update(Photo photo){
        photoRepository.save(photo);
        return new ModelAndView("redirect:/admin/photoList");
    }

    // 修改
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        System.out.println(id);
        Photo photo = photoRepository.findOne(id);
        return new ModelAndView("admin/photoEdit", "photo", photo);
    }

    // 新增页
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPhoto(){
        return "/admin/photoAdd";
    }

    // 新增
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Photo photo, @RequestParam("file") MultipartFile file){
        photo.setPostDate(new Date());
        photoRepository.save(photo);
        return "redirect:/admin/photoList";
    }

}
