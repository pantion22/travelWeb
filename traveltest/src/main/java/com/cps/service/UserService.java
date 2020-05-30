package com.cps.service;

import com.cps.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // 查询用户
    User find(String username,String password);

    // 修改密码
    void update(Integer id,String password);

}
