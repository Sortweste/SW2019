package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupRepository extends JpaRepository<Group, Long> {

    List<Group> findGroupsByChurch(Church church); //Inyección de dependencias

}

