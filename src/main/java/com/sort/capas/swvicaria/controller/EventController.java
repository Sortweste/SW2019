package com.sort.capas.swvicaria.controller;



import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    IEventService ieventService;

    //@Secured("ROLE_LIDER")
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


        ieventService.save(e);

        return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }

}
