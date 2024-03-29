package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.DTO.ChurchGroupDTO;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IGroupService;
import com.sort.capas.swvicaria.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Group")
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IChurchService churchService;

    @Autowired
    private IUserService userService;


    //Mostrar la lista de los grupos.
    @GetMapping("/")
    public String init(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "church";
    }

    //Permite a un lider crear un grupo en una iglesia.
    @Secured("ROLE_LIDER")
    @GetMapping("/create")
    public String add(Model model){
        List<Church> churches = churchService.findAll();
        ChurchGroupDTO group = new ChurchGroupDTO();
        group.setChurch(churches);
        model.addAttribute("group", group);
        return "GroupForm";
    }

    //Permite a un lider guardar un grupo creado.
    @Secured("ROLE_LIDER")
    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group, @RequestParam("Churchid") long id){
        groupService.save(group, id);
        return "redirect:/";
    }

    //Muestra la lista de grupos de una iglesia.
    @PostMapping("/showByChurch")
    public String showGroups( Model model,@RequestParam("id") long id){
        List<Group> groups =groupService.findGroupsByChurch(id);
        model.addAttribute("groups", groups);
        return "church";
    }

    //Muestra un grupo en epecifico.
    @PostMapping("/showGroup")
    public String showGroup( Model model,@RequestParam("id") long id){
        Group group = groupService.findGroup(id);
        List<Group> g = groupService.findAll();
        model.addAttribute("group", group);
        model.addAttribute("groups",g);
        return "group";
    }

}
