package com.example.webapp.repository;

import com.example.webapp.domain.Infos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<Infos, Long> {
}
