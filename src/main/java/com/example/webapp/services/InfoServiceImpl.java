package com.example.webapp.services;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Items;
import com.example.webapp.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfoServiceImpl implements InfoService{

    InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }


    @Override
    public List<Infos> findAll() {
        List<Infos> infos = new ArrayList<>();
        infoRepository.findAll().iterator().forEachRemaining(infos::add);
        return infos ;
    }

    @Override
    public Infos save(Infos info) {
        Infos savedInfo = infoRepository.save(info);
        return savedInfo;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Infos> infoOptional = infoRepository.findById(id);
        if (!infoOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        Infos info = infoOptional.get();

        infoRepository.save(info);
        infoRepository.deleteById(id);

    }

    @Override
    public Infos findById(Long l) {
        Optional<Infos> infoOptional = infoRepository.findById(l);
        if (!infoOptional.isPresent()) {
            throw new RuntimeException("Info not found!");
        }
        return infoOptional.get();
    }
}
