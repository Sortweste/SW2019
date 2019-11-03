package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.User;
import com.sort.capas.swvicaria.repository.IRoleRepository;
import com.sort.capas.swvicaria.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

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

    @Override
    @Transactional
    public User becomeMember(Long id) {
        long var=2;
        User user=userRepository.findUserById(id);
        user.setRole(roleRepository.findRoleById(var));
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User becomeLeader(Long id) {
        long var=1;
        User user=userRepository.findUserById(id);
        user.setRole(roleRepository.findRoleById(var));
        return userRepository.saveAndFlush(user);

    }

    @Override
    @Transactional
    public User becomeUser(Long id) {
        long var=3;
        User user=userRepository.findUserById(id);
        user.setRole(roleRepository.findRoleById(var));
        return userRepository.saveAndFlush(user);
    }
}
