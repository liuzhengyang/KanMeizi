package com.kanmeizi.controller;

import com.kanmeizi.entity.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by liuzhengyang on 2014/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-service.xml")
@Transactional
public class HomeControllerTest {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Test
    public void testInit(){
        Photo photo = new Photo();
        photo.setPostDate(new Date());
        photo.setSrc("www.kanmeizi.com");
        photo.setTitle("01");

        hibernateTemplate.save(photo);
        System.out.println(hibernateTemplate.get(Photo.class, 1L));
    }

}
