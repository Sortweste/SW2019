package com.sort.capas.swvicaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupController {

    @RequestMapping("Group")
    public String init(){
        return "GroupForm";
    }

}
