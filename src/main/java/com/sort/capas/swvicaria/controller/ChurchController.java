package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.service.IChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


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
    public String add(Model model){
        model.addAttribute("church", new Church());
        return "addChurch";
    }

    @PostMapping("/saveChurch")
    public String saveChurch(@ModelAttribute("church") Church church, @RequestParam("foto") MultipartFile foto){
        churchService.save(church, foto);
        return "redirect:/";
    }

    @PostMapping("/")
    public String showGroupsByChurch(@RequestParam("p_id") Long id, Model model){
        model.addAttribute("groups", churchService.findChurchById(id).getGroups());
        return "index";
    }

}
