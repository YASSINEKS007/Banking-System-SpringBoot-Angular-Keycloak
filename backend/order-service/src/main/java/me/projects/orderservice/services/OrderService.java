package me.projects.orderservice.services;

import me.projects.orderservice.entities.Order;

public interface OrderService {
    Order createOrder(Order order);
}
