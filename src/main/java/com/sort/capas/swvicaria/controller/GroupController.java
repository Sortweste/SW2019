package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Group")
public class GroupController {


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

}
