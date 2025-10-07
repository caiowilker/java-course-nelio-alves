package org.example.project_web.demo.src.test.java.com.example.demo.services;

import org.example.project_web.demo.src.test.java.com.example.demo.entities.Order;
import org.example.project_web.demo.src.test.java.com.example.demo.entities.User;
import org.example.project_web.demo.src.test.java.com.example.demo.repositories.OrderRepository;
import org.example.project_web.demo.src.test.java.com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

}
