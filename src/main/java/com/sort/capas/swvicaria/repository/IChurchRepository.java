package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Church;
import org.springframework.data.jpa.repository.JpaRepository;
//Repositorio de iglesias
public interface IChurchRepository extends JpaRepository<Church, Long> {

        Church findChurchById(Long id);
}
