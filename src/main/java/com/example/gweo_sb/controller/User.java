//理解为我的数据库名为为User
package com.example.gweo_sb.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//总之，这个类的目的是定义一个JPA实体，
// 它可以映射到数据库表，（理解为创建了一个数据库）该表具有自动生成的主键（使用自增长策略），
// 以及两个普通属性 upload_domain 和 load_Content。这允许你使用JPA框架来管理与该实体相关的数据库操作。



//@Entity: 这是一个注解，用于将这个类标记为JPA实体。这表示该类的对象可以映射到数据库表。
//@Id: 这是一个注解，用于标识对象的主键属性。
//@GeneratedValue(strategy = GenerationType.IDENTITY): 这是另一个注解，它指定了主键的生成策略。
// 在这里，它使用了GenerationType.IDENTITY，这意味着主键将由数据库自动分配，通常是一个自增长的整数。


//@Entity 注解：这个注解用于标识类 User 为一个JPA实体。
// JPA（Java Persistence API）是Java EE标准中的一部分，用于将Java对象映射到数据库表。
// 通过使用 @Entity 注解，你告诉JPA框架，这个类的对象可以映射到数据库表中的记录。
@Entity
public class User {
    //这个注解用于标识 id 字段作为实体的主键。主键是用来唯一标识数据库表中的每一行数据的字段。
    @Id
    //注解：这个注解指定主键的生成策略。在这里，使用了 GenerationType.IDENTITY，它表示主键将由数据库自动分配。
    // 通常，这是一个自增长的整数，也就是数据库会自动为每行数据分配一个唯一的整数值，以充当主键。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //然后，你的实体类定义了两属性
    //id：这是主键字段，使用 @Id 和 @GeneratedValue 注解定义。
    //upload_domain：这是一个普通的字符串属性。
    //load_Content：这也是一个普通的字符串属性。
    //此外，你的类可能还包含构造函数、Getter和Setter方法，但它们在提供的代码片段中没有显示出来。
    // 这些方法用于创建对象实例以及获取和设置属性的值。
    private String upload_domain;

    public String getUpload_domain() {
        return upload_domain;
    }

    private String load_Content;

    public String getLoad_Content() {
        return load_Content;
    }
// 构造函数、Getter和Setter方法
    public String upload_time;
    public  String getUpload_time(){return upload_time;}
}


