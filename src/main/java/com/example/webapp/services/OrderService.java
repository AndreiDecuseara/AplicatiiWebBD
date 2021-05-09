package com.example.webapp.services;


import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();
    void deleteById(Long id);
    Orders findById(Long l);
}
