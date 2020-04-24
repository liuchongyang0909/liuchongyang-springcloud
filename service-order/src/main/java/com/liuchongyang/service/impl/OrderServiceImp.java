package com.liuchongyang.service.impl;

import com.liuchongyang.Order;
import com.liuchongyang.mapper.OrderMapper;
import com.liuchongyang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderMapper.getOrderById(id);
        return order;
    }

    @Override
    public List findAll() {
        return orderMapper.findAll();
    }
}
