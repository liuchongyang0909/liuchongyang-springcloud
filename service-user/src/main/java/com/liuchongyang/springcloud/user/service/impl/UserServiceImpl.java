package com.liuchongyang.springcloud.user.service.impl;

import com.liuchongyang.User;
import com.liuchongyang.springcloud.user.mapper.UserMapper;
import com.liuchongyang.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public String getUserNameById(Integer id) {
        User user = userMapper.getUserNameById(id);
        return user.getUsername();
    }

    public User getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }
}
