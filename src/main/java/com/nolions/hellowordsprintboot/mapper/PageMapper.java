package com.nolions.hellowordsprintboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nolions.hellowordsprintboot.model.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageMapper extends BaseMapper<Page> {
    List<Page> getAllPageRoles();
}
