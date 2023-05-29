package com.nolions.hellowordsprintboot.controller;

import com.nolions.hellowordsprintboot.mapper.UserMapper;
import com.nolions.hellowordsprintboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println(("size:" + userList.size()));
        userList.forEach(System.out::println);
        return String.format("Hello %s!", name);

    }
}
