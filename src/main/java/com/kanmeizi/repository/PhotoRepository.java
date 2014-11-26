package com.kanmeizi.repository;

import com.kanmeizi.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
