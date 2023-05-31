package com.nolions.hellowordsprintboot.service;

import com.nolions.hellowordsprintboot.mapper.PageMapper;
import com.nolions.hellowordsprintboot.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PageService {

    @Autowired
    PageMapper pageMapper;

    public List<Page> getAllPageRoles(){
        return pageMapper.getAllPageRoles();
    }
}
