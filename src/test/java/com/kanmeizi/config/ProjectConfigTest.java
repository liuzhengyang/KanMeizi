package com.kanmeizi.config;

import com.kanmeizi.repository.PhotoRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
public class ProjectConfigTest {

    @Test
    public void bootstrapAppFromJavaConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
        assertNotNull(applicationContext);
        assertNotNull(applicationContext.getBean(PhotoRepository.class));
        assertNotNull(applicationContext.getBean(PhotoRepository.class));
    }
}
