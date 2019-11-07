package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    IEventRepository ieventRepository;


    @Override
    @Transactional
    public Event save(Event e) throws ParseException {
        return ieventRepository.save(e);
    }
}
