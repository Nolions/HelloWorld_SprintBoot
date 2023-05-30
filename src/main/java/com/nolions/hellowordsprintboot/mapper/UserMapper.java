package com.nolions.hellowordsprintboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nolions.hellowordsprintboot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(@Param("username") String username);
}
