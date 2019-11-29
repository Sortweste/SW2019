package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Event;

import java.text.ParseException;
import java.util.List;

//Servicio de event
public interface IEventService {
    List <Event> findAll();
    Event findEventById(Long id);
    public Event save(Event e) throws ParseException;

}
