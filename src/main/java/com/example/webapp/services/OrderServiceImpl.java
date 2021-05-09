package com.example.webapp.services;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Orders;
import com.example.webapp.repository.InfoRepository;
import com.example.webapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Orders> findAll() {
        List<Orders> orders = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orders::add);
        return orders ;
    }


    @Override
    public void deleteById(Long id) {
        Optional<Orders> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not found!");
        }
        Orders order = orderOptional.get();

        orderRepository.save(order);
        orderRepository.deleteById(id);

    }

    @Override
    public Orders findById(Long l) {
        Optional<Orders> orderOptional = orderRepository.findById(l);
        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order not found!");
        }
        return orderOptional.get();
    }

}
