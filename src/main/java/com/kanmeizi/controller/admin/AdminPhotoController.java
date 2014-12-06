package com.kanmeizi.controller.admin;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import com.kanmeizi.util.BasePathUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
        return new ModelAndView("/admin/photoList", "photos", photoRepository.findOrderByPostDateDesc());
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

    private static final String LOCATION_PREFIX = "/image/picture/";
    private static final String IMAGE_URL_PREFIX = "/picture/";

    // 新增
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Photo photo, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if(!file.isEmpty()){
            // webapp路径
            String webapppath = request.getSession().getServletContext().getRealPath("");
            logger.info(webapppath);
            // 存放图片的路径
            File parentDir = new File(webapppath + LOCATION_PREFIX);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }
            File toFile = new File(parentDir, file.getOriginalFilename());
            file.transferTo(toFile);
            // 设置上传时间
            photo.setPostDate(new Date());
            // 设置图片url
            photo.setSrc(BasePathUtil.getBasePath(request) + IMAGE_URL_PREFIX + file.getOriginalFilename());
            photoRepository.save(photo);
        }
        return "redirect:/admin/photoList";
    }

    private String getUrlForImage(){
        return null;
    }

    @RequestMapping("/downloadimage")
    public void downloadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-disposition","attachment; filename=" + "图片下载");
        byte[] buffer = new byte[1024];
        File file = new File("C:\\Users\\liuzhengyang\\Pictures\\road.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        while(fileInputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }

        outputStream.close();
        fileInputStream.close();
    }
}
