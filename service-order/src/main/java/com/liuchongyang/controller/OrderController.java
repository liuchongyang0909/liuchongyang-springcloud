package com.liuchongyang.controller;

import com.liuchongyang.Order;
import com.liuchongyang.User;
import com.liuchongyang.service.OrderService;
import com.liuchongyang.interfaces.UserFeginClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeginClient userFeginClient;

    @RequestMapping("getOrderById")
    @HystrixCommand(fallbackMethod = "getUserByIdFallbackMethod")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order orderById = orderService.getOrderById(id);

        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id=1", User.class);
        User user = userFeginClient.getUserById(1);

        orderById.setUsername(user.getUsername());

        return orderById;
    }

    @RequestMapping("findAll")
    public Object findAll() {
        return orderService.findAll();
    }

    public Order getUserByIdFallbackMethod(Integer id){
        Order order = new Order();
        order.setUsername("调用错误");
        return order;
    }
}
