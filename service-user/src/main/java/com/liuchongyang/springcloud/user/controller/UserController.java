package com.liuchongyang.springcloud.user.controller;

import com.liuchongyang.User;
import com.liuchongyang.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUserNameById")
    public String getUserNameById(@RequestParam("id") Integer id) {
        return userService.getUserNameById(id);
    }

    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Integer id){
        System.out.println("222222");
        return userService.getUserById(id);
    }
}
