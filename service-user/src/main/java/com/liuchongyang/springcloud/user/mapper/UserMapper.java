package com.liuchongyang.springcloud.user.mapper;

import com.liuchongyang.User;

public interface UserMapper {

    User getUserNameById(Integer id);

    User getUserById(Integer id);
}
