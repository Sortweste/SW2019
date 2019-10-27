package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChurchRepository extends JpaRepository<Church, Long> {

        Church findChurchById(Long id);
}
