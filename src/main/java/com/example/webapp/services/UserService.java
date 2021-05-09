package com.example.webapp.services;


import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();
}
