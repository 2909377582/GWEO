//此类用于操作数据库
package com.example.gweo_sb.controller;
//导入了repository接口
import com.example.gweo_sb.repository.DataRepository;
import com.example.gweo_sb.repository.UserRepository;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class Usercontroller {

    //@Autowired（自动装配）：此注解用于自动装配UserRepository对象，实现依赖注入。
    @Autowired
    //定义私有变量userRepository，是一个接口类型的变量
    private UserRepository userRepository;
    @Autowired
    private DataRepository dataRepository;

    //public User createUser(@RequestBody User user)：这是一个处理创建用户的方法。
    // @RequestBody注解将请求的JSON体映射到User对象上。
    // 然后，通过调用userRepository.save(user)将用户信息保存到数据库中，并返回保存后的用户对象。
    //User是返回类型，用于返回一个对象，例如void：有返回值。
    //User user: 这声明了一个名为 user、类型为 User ，例如一个string类型的user,的参数。该参数代表从请求体中传递的数据，通常是 JSON 格式的数据，适用于 POST 请求。
    @PostMapping("/receiveData")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/data")
    public  List<User> getAllData() {
        return dataRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

}

