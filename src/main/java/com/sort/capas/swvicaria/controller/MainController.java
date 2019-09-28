package com.sort.capas.swvicaria.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("VicariaSW")
public class MainController {

    @GetMapping("/")
    public String redirect(){
        return "redirect:/VicariaSW/Church";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("VicariaSW/Church")
    public String churchController(){
        return "forward:/Church/";
    }

}
