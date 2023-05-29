package com.nolions.hellowordsprintboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nolions.hellowordsprintboot.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
