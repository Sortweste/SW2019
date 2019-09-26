package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.service.IChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Test")
public class ControllerTest {

    @Autowired
    IChurchService iChurchService;

    @GetMapping("/form")
    public String formTest(){
        return "churchform" ;
    }

    @GetMapping("/GetAllChurchs")
    public List<Church> getAllChurchs() {
        return iChurchService.findAll();
    }

    @GetMapping("/church")
    public String showChurch(Model model) {
        /*model.addAttribute("ch",list);
        model.addAttribute("one",single);
        */return "church";
    }
}

