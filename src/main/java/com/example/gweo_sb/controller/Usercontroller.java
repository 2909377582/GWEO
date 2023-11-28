//此类用于操作数据库
package com.example.gweo_sb.controller;
//导入了repository接口
import com.example.gweo_sb.repository.UserRepository;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Usercontroller {

    //@Autowired（自动装配）：此注解用于自动装配UserRepository对象，实现依赖注入。
    @Autowired
    //定义私有变量userRepository，是一个接口类型的变量
    private UserRepository userRepository;

    //public User createUser(@RequestBody User user)：这是一个处理创建用户的方法。
    // @RequestBody注解将请求的JSON体映射到User对象上。
    // 然后，通过调用userRepository.save(user)将用户信息保存到数据库中，并返回保存后的用户对象。
    @PostMapping("/receiveData")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/data")
    public User findLatestUser() {

        // 调用定义的查询方法
        return userRepository.findTopByOrderByIdDesc();

    }
}

