package com.cps.mapper;

import com.cps.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    // 查询用户
    User find(String username,String password);

    // 修改密码
    void update(@Param("id") Integer id, @Param("password") String password);

}
