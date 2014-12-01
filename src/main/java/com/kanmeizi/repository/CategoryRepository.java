package com.kanmeizi.repository;

import com.kanmeizi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liuzhengyang on 2014/11/30.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    @Query("select c from Category c where c.parent")
//    List<Category> getChildrenCategory(Long id);

}
