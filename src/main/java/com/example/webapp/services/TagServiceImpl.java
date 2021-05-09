package com.example.webapp.services;

import com.example.webapp.domain.Items;
import com.example.webapp.domain.Tags;
import com.example.webapp.repository.TagRepository;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    TagRepository tagRepository;

    @Autowired
    public TagServiceImpl( TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }


    @Override
    public List<Tags> findAll() {
        List<Tags> tags = new ArrayList<>();
        tagRepository.findAll().iterator().forEachRemaining(tags::add);
        return tags ;
    }

    @Override
    public Tags save(Tags tag) {
        Tags savedTag = tagRepository.save(tag);
        return savedTag;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Tags> tagOptional = tagRepository.findById(id);
        if (!tagOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        Tags tag = tagOptional.get();

        tagRepository.save(tag);
        tagRepository.deleteById(id);

    }

    @Override
    public Tags findById(Long l) {
        Optional<Tags> productOptional = tagRepository.findById(l);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        return productOptional.get();
    }
}
