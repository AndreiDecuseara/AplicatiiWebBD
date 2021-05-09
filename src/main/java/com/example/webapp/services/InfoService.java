package com.example.webapp.services;


import com.example.webapp.domain.Infos;

import java.util.List;

public interface InfoService {
    List<Infos> findAll();

    Infos save(Infos info);

    void deleteById(Long id);

    Infos findById(Long l);
}
