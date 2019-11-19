package com.sort.capas.swvicaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Message")
public class MessageController {

    @GetMapping("/List")
    public String groupDashBoard(){
        return "email";
    }
}
