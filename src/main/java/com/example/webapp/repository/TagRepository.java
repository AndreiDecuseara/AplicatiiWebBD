package com.example.webapp.repository;

import com.example.webapp.domain.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.HTML;

@Repository
public interface TagRepository extends CrudRepository<Tags, Long> {
}
