package com.example.webapp.services;

import com.example.webapp.domain.Infos;
import com.example.webapp.domain.Users;
import com.example.webapp.repository.InfoRepository;
import com.example.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public List<Users> findAll() {
        List<Users> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users ;
    }

}
