package com.kanmeizi.repository;

import com.kanmeizi.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Query("select p from Photo p order by p.postDate desc")
    List<Photo> findOrderByPostDateDesc();


    List<Photo> findBySrcContainingOrTitleContaining(String src, String title);
}
