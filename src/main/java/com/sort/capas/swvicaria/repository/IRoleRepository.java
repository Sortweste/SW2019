package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio de role
public interface IRoleRepository  extends JpaRepository<Role,Long> {
     Role findRoleById(Long id);
}
