package com.kanmeizi.init;

import com.kanmeizi.entity.Photo;
import com.kanmeizi.repository.PhotoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ContextResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.ServletContextResource;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

/** 初始化测试用数据
 * Created by liuzhengyang on 2014/11/26.
 */
//@Component
//@Transactional
public class InitData{

//    private static final Logger logger = Logger.getLogger(InitData.class);
//    @Autowired
//    PhotoRepository photoRepository;
//
//
//    // 加载本地下的资源
//    @PostConstruct
//    public void initData() throws IOException {
//        Resource resource = new ClassPathResource("image");
//        File dir = resource.getFile();
//        logger.info(dir.isDirectory());
//        String[] imageNames = dir.list();
//        for(String s : imageNames){
//
//        }
//    }
//
//    private void emulateUpload(File file){
//        Photo photo = new Photo();
//        photo.setSrc(file.getName());
//        photo.setPostDate(new Date());
//        photo.setTitle(file.getName());
//        photoRepository.save(photo);
//        File file =
//    }
}
