package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.User;
import com.sort.capas.swvicaria.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
