package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.service.IChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Church")
public class ChurchController {

    @Autowired
    private IChurchService churchService;

    @GetMapping("/")
    public String showAll(){
        return "hotels";
    }

}
