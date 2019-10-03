package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGroupRepository extends JpaRepository<Group, Long> {

    List<Group> findGroupsByChurch(Church church);

}

