package com.sort.capas.swvicaria.controller;


import com.sort.capas.swvicaria.DTO.FormDTO;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    IEventService ieventService;

    /*@Secured("ROLE_LIDER")
    @RequestMapping(value="/saveEvent", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<String> saveEvent(@RequestBody FormDTO[] form) throws Exception{
        Event event = ieventService.save(form);

        return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }*/

    @RequestMapping("/saveEvent")
    public @ResponseBody ResponseEntity<String> saveEvent(@RequestParam("author") String author, @RequestParam("sub_author") String sub_author,
                                                          @RequestParam("persona") String persona, @RequestParam("title") String title,
                                                          @RequestParam("info") String info, @RequestParam("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                                          @RequestParam("time") String time, @RequestParam("cost") double cost) throws Exception{


        Event e = new Event();
        e.setAuthor(author);
        e.setSub_author(sub_author);
        e.setPersona(persona);
        e.setTitle(title);
        e.setInformation(info);
        e.setDate_start(date);
        e.setTime(time);
        e.setCost(cost);


        Event event = ieventService.save(e);

        return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }

}
