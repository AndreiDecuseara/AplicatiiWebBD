package com.example.webapp.services;

import com.example.webapp.domain.Items;

import java.util.List;

public interface ItemService {
    List<Items> findAll();
    Items findById(Long l);
    Items save(Items item);
    void deleteById(Long id);

}
