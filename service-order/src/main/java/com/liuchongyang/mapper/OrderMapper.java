package com.liuchongyang.mapper;

import com.liuchongyang.Order;

import java.util.List;

public interface OrderMapper {
    Order getOrderById(Integer id);

    List findAll();
}
