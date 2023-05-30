package com.nolions.hellowordsprintboot.service;

import com.nolions.hellowordsprintboot.mapper.UserMapper;
import com.nolions.hellowordsprintboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User loadUserByUsername(String username) {
        userMapper.loadUserByUsername(username);
        return null;
    }
}
