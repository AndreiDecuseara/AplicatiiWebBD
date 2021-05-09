package com.example.webapp.repository;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
}
