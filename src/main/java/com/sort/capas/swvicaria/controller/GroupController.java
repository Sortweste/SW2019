package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Group")
public class GroupController {

    @Autowired
    private IGroupService groupService;


    @GetMapping("/")
    public String init(){
        return "church";
    }

    @GetMapping("/Test")
    public String initTest(){
        return "church";
    }

    @Secured("ROLE_LIDER")
    @GetMapping("/create")
    public String add(Model model){
        model.addAttribute("group", new Group());
        return "GroupForm";
    }

    @PostMapping("/saveGroup")
    public String saveChurch(@ModelAttribute("group") Group group, @RequestParam("id") long id){
        groupService.save(group, id);
        return "redirect:/";
    }

}
