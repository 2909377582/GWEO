package com.example.gweo_sb.repository;


import com.example.gweo_sb.controller.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // 您可以在这里添加自定义的查询方法
}

