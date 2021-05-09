package com.example.webapp.repository;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {
}
