package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio de user
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findByUsername(String username);
}
