package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.DTO.FormDTO;
import com.sort.capas.swvicaria.domain.Event;

import java.text.ParseException;

public interface IEventService {

    // public Event save(FormDTO[] dto) throws ParseException;
    public Event save(Event e) throws ParseException;

}
