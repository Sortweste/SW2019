package com.sort.capas.swvicaria.repository;

import com.sort.capas.swvicaria.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event,Long> {
}
