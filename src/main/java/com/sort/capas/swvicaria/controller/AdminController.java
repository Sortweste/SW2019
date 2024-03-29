package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured("ROLE_LIDER")
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    IChurchService iChurchService;

    @Autowired
    IGroupService iGroupService;

    @Autowired
    IEventService iEventService;

    // Redirige hacia la pagina de administrador de eventos.
    @GetMapping("/Event")
    public String eventDashBoard(Model model){
        model.addAttribute("events",iEventService.findAll());
        return "adminDashboard";
    }

    @PostMapping("/editEvent")
    public String eventModify(Model model, @RequestParam("id") Long id){
        Event e = new Event();
        e = iEventService.findEventById(id);
        model.addAttribute("event", e);
        return "editEvent";
    }

    @PostMapping("/modifyEvent")
    public String saveEve(@ModelAttribute("event") Event eve){
        return "redirect:/";
    }

    // Redirige hacia la pagina de administrador de iglesias.
    @GetMapping("/Church")
    public String churchDashBoard(Model model){
        model.addAttribute("churches", iChurchService.findAll());
        return "adminChurch";
    }

    // Redirige hacia la pagina de administrador de grupos.
    @GetMapping("/Group")
    public String groupDashBoard(Model model){
        model.addAttribute("groups", iGroupService.findAll());
        return "adminGroup";
    }

    // Muestra la lista de miembros en un grupo.
    @PostMapping("/Members")
    public String manageMembersByGroup(@RequestParam("id") Long id, Model model){
        model.addAttribute("members", iGroupService.findGroup(id).getUsers());
        return "adminMembers";
    }

}
