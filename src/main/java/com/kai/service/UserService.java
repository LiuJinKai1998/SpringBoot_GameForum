package com.kai.service;

import com.kai.mapper.UserMapper;
import com.kai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public User ll(String username,String password){
        return userMapper.ll(username,password);
    }

    public int newUser(User user){
        return userMapper.newUser(user);
    }

    public int updateUser(User user) {

        return userMapper.updateUser(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    public int regUser(User user){
        return userMapper.regUser(user);
    }

}
