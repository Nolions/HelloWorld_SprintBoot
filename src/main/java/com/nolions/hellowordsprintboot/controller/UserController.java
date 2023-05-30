package com.nolions.hellowordsprintboot.controller;

import com.nolions.hellowordsprintboot.mapper.UserMapper;
import com.nolions.hellowordsprintboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/heartbeat")
    public ResponseEntity<Object> heartBeat() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(("----- selectAll method test ------"));

        return String.format("Hello %s!", name);

    }

    @GetMapping(path = "/user/{name}")
    public ResponseEntity<Object> user(@PathVariable String name) {
        System.out.println(("----- get user ------"));
        User user = userMapper.loadUserByUsername(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
