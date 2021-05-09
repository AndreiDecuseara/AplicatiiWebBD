package com.example.webapp.services;


import com.example.webapp.domain.Items;
import com.example.webapp.domain.Tags;

import javax.swing.text.html.HTML;
import java.util.List;

public interface TagService {
    List<Tags> findAll();

    Tags save(Tags tag);

    void deleteById(Long id);

    Tags findById(Long l);
}
