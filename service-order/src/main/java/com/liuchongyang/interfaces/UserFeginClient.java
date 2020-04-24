package com.liuchongyang.interfaces;

import com.liuchongyang.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-user",fallback = UserFeignCallback.class)
public interface UserFeginClient {
    @RequestMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);

    @RequestMapping("/user/getUserById")
    public User getUserById(@RequestParam("id") Integer id);
}
