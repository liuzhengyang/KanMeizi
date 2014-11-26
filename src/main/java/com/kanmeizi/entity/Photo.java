package com.kanmeizi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 图片title
    private String title;
    // 上传时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date postDate;
    // 图片src
    private String src;

    public Photo() {
    }

    public Photo(String title, String src) {
        this.title = title;
        this.src = src;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postDate=" + postDate +
                ", src='" + src + '\'' +
                '}';
    }
}
