package com.liuchongyang.springcloud.user.service;

import com.liuchongyang.User;

public interface UserService {
    String getUserNameById(Integer id);

    User getUserById(Integer id);
}
