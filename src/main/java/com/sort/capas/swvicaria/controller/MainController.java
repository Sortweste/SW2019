package com.sort.capas.swvicaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //Manda a la pagina principal por defecto.
    @GetMapping("/")
    public String redirect(){
        return "redirect:/VicariaSW/Church";
    }

    //Redirigen al login
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //Redirige a la pagina principal.
    @GetMapping("VicariaSW/Church")
    public String churchController(){ return "forward:/Church/"; }

}
