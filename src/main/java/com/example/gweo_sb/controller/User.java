package com.example.gweo_sb.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//@Entity: 这是一个注解，用于将这个类标记为JPA实体。这表示该类的对象可以映射到数据库表。
//@Id: 这是一个注解，用于标识对象的主键属性。
//@GeneratedValue(strategy = GenerationType.IDENTITY): 这是另一个注解，它指定了主键的生成策略。
// 在这里，它使用了GenerationType.IDENTITY，这意味着主键将由数据库自动分配，通常是一个自增长的整数。


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String upload_domain;

    public String getUpload_domain() {
        return upload_domain;
    }

    private String load_Content;

    public String getLoad_Content() {
        return load_Content;
    }
// 构造函数、Getter和Setter方法
}


