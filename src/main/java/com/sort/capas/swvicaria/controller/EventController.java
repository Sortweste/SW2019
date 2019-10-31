package com.sort.capas.swvicaria.controller;


import com.sort.capas.swvicaria.DTO.FormDTO;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    IEventService ieventService;

    //@Secured("ROLE_LIDER")
    @RequestMapping(value="/saveEvent", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<String> saveEvent(@RequestBody FormDTO[] form) throws Exception{
        Event event = ieventService.save(form);

        return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }

}
