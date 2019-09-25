package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChurchServiceImpl implements IChurchService {

    @Autowired
    IChurchRepository churchRepository;

    @Override
    public List<Church> findAll() {
        return churchRepository.findAll();
    }

    @Override
    public Church findChurchById(Long id) {
        return churchRepository.findChurchById(id);
    }


    @Override
    @Transactional
    public Church save(Church church) {
        return churchRepository.save(church);
    }
}
