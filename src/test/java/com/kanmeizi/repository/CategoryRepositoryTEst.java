package com.kanmeizi.repository;

import com.kanmeizi.entity.Category;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuzhengyang on 2014/11/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-service.xml")
@Transactional
public class CategoryRepositoryTest {

    private static final Logger logger = Logger.getLogger(CategoryRepositoryTest.class);

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void testInsert(){
        Category category = new Category();
        category.setName("cate1");
        categoryRepository.save(category);
        Category cate2 = new Category();
        Category cate3 = new Category();
        cate2.setName("cate2");
        cate3.setName("cate3");
        cate2.setParent(category);
        cate3.setParent(category);
        categoryRepository.save(cate2);
        categoryRepository.save(cate3);
        logger.info(category);
    }
}
