package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    IEventRepository ieventRepository;


    @Override
    public List<Event> findAll() {
        return ieventRepository.findAll();
    }

    @Override
    public Event findEventById(Long id) {
        return ieventRepository.findEventById(id);
    }

    @Override
    @Transactional
    public Event save(Event e) throws ParseException {
        return ieventRepository.save(e);
    }
}
