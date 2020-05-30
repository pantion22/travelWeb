package com.cps.service.impl;

import com.cps.mapper.UserMapper;
import com.cps.pojo.User;
import com.cps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User find(String username,String password) {
        return userMapper.find(username,password);
    }

    @Override
    public void update(Integer id, String password){ userMapper.update(id, password);}
}
