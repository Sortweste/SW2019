package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.service.IChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Church")
public class ChurchController{

    @Autowired
    private IChurchService churchService;

    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("churchs", churchService.findAll());
        return "hotels";
    }

    @GetMapping("/create")
    public String add(){
        return "addChurch";
    }

    @PostMapping("/saveChurch")
    public String saveChurch(){

        return "index";
    }

    @PostMapping("/")
    public String showGroupsByChurch(@RequestParam("p_id") Long id, Model model){
        model.addAttribute("groups", churchService.findChurchById(id).getGroups());
        return "index";
    }

}
