package com.liuchongyang.interfaces;

import com.liuchongyang.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignCallback implements UserFeginClient {
    @Override
    public String getUsernameById(Integer id) {
        return "服务调用失败"+id;
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setUsername("服务调用失败"+id);
        return user;
    }
}
