package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Event;

import java.text.ParseException;

public interface IEventService {

    public Event save(Event e) throws ParseException;

}
