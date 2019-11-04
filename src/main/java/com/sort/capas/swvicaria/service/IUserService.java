package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findUserByName(String name);
    User findUserById(Long id);
    User becomeMember(Long id);
    User becomeLeader(Long id);
    User becomeUser(Long id);
}

