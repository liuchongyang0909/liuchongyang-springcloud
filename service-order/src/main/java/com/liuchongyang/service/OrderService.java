package com.liuchongyang.service;

import com.liuchongyang.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order getOrderById(Integer id);

    List findAll();
}
