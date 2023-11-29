package com.example.gweo_sb.repository;

import com.example.gweo_sb.controller.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface DataRepository extends JpaRepository<User,Long>{

}
