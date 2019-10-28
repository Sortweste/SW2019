package com.sort.capas.swvicaria.controller;


import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    IEventService ieventService;

    //@Secured("ROLE_LIDER")
    @PostMapping("/saveEvent")
    public ResponseEntity<String> saveEvent(){
       // ieventService.save(event);
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

}
