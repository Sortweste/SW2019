package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @PostMapping("/Group/Members")
    public String manageMembersByGroup(@RequestParam("id") Long id, Model model){
        model.addAttribute("members", iGroupService.findGroup(id).getUsers());
        return "adminMembers";
    }

}
