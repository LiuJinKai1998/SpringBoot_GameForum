package com.kai.mapper;

import com.kai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface UserMapper {

    //查询全部信息
    List<User> getUserList();

    //根据id查询信息
    User getUserById(int id);

    User ll(String username,String password);

    //新增
    int newUser(User user);

    //注册
    int regUser(User user);

    //修改
    int updateUser(User user);

    //删除
    int deleteUser(int id);


}
