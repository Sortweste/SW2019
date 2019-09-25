package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Church;

import java.util.List;

public interface IChurchService {
    List<Church> findAll();
    Church findChurchById(Long id);
    Church save(Church church);
}
