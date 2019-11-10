package com.sort.capas.swvicaria.controller;



import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.domain.GroupxEvent;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupxEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    IEventService ieventService;

    @Autowired
    IGroupxEventService iGroupxEventService;

    @Secured("ROLE_LIDER")
    @PostMapping("/saveEvent")
    public @ResponseBody ResponseEntity<String> saveEvent(@RequestParam("author") Integer author, @RequestParam("sub_author") Integer sub_author,
                                                          @RequestParam("persona") String persona, @RequestParam("title") String title,
                                                          @RequestParam("info") String info, //@RequestParam("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                                          @RequestParam("time") String time, @RequestParam("cost") double cost) throws Exception{


        Event e = new Event();
        e.setAuthor(author);
        e.setSub_author(sub_author);
        e.setPersona(persona);
        e.setTitle(title);
        e.setInformation(info);
        //e.setDate_start(date);
        e.setDate_start(new Date());
        e.setTime(time);
        e.setCost(cost);

        Event event = ieventService.save(e);
        GroupxEvent gxe = new GroupxEvent();
        gxe.setEvent(event);
        Group group = new Group();
        group.setId(Long.parseLong(String.valueOf(author)));
        gxe.setGroup2(group);
        GroupxEvent groupxEvent = iGroupxEventService.save(gxe);


        return new ResponseEntity<>("hola", HttpStatus.CREATED);
    }

}
