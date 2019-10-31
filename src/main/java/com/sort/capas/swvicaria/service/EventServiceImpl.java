package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.DTO.FormDTO;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    IEventRepository ieventRepository;

    @Override
    @Transactional
    public Event save(FormDTO[] dto) throws ParseException {
        List<FormDTO> objetos = Arrays.asList(dto);

        Event e = new Event();
        for(FormDTO d : dto) {
            if (d.getName().equals("author")) e.setAuthor(d.getValue());
            if (d.getName().equals("sub_author")) e.setSub_author(d.getValue());
            if (d.getName().equals("title")) e.setTitle(d.getValue());
            if (d.getName().equals("info")) e.setInformation(d.getValue());
            if (d.getName().equals("start")) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
                Date date = formatter.parse(d.getValue());
                e.setDate_start(date);
            };
            if (d.getName().equals("time")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
                String time = String.format(d.getValue(), formatter);
                e.setTime(time);
            };

        }


        return ieventRepository.save(e);
    }
}
