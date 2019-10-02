package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.DTO.ChurchGroupDTO;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IGroupService;
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


    @GetMapping("/")
    public String init(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "church";
    }

    @GetMapping("/Test")
    public String initTest(){
        return "church";
    }

    @Secured("ROLE_LIDER")
    @GetMapping("/create")
    public String add(Model model){
        List<Church> churches = churchService.findAll();
        ChurchGroupDTO group = new ChurchGroupDTO();
        group.setChurch(churches);
        model.addAttribute("group", group);
        return "GroupForm";
    }

    @PostMapping("/saveGroup")
    public String saveChurch(@ModelAttribute("group") Group group, @RequestParam("id") long id){
        groupService.save(group, id);
        return "redirect:/";
    }

}
