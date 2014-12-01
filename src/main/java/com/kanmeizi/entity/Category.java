package com.kanmeizi.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * 分类
 * Created by liuzhengyang on 2014/11/28.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 分类名
    private String name;
    // 父节点
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;
    // 子节点
    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> children;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
