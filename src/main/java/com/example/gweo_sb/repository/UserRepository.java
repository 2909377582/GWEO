//这是一个 Java 接口，它是 Spring Data JPA 提供的一个 repository 接口，
// 用于对应用程序中的用户（User）实体进行数据库操作。
package com.example.gweo_sb.repository;


// 这一行导入了一个名为 User 的类，这个类是用于表示用户的实体。
// 通常，这个类包含了用户的属性和相关的方法。在这里，它被用作 Spring Data JPA 的实体类。
import com.example.gweo_sb.controller.User;

// 这一行导入了 Spring Data JPA 的 CrudRepository 接口。
// CrudRepository 提供了一组基本的 CRUD（Create, Read, Update, Delete）操作方法，
// 允许你执行对数据库的常见操作。
import org.springframework.data.repository.CrudRepository;

//这一行定义了一个接口 UserRepository，它继承了 CrudRepository 接口，
// 并且指定了两个泛型参数：User 和 Long。
// 这里的 User 表示实体类的类型，Long 表示实体类的主键类型。
public interface UserRepository extends CrudRepository<User, Long> {
    // 您可以在这里添加自定义的查询方法
    //对User这个实体（映射为数据库中的表）进行一个查询（查询内容为最后一行内容）
    //这个方法的作用是查询数据库中 User 表中按照 id 字段降序排列的第一条记录，并返回相应的 User 实体对象。这样的查询通常用于获取表中的最新记录。
}

