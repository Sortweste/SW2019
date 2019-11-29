package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.service.IChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/Church")
public class ChurchController{

    @Autowired
    private IChurchService churchService;

    Authentication auto = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("churchs", churchService.findAll());
        return "hotels";
    }

    @PostMapping("/Detail")
    public String showChurch(@RequestParam("id") Long id,Model model){
        model.addAttribute("church", churchService.findChurchById(id));
        return "churchDetail";
    }

    @Secured("ROLE_LIDER")
    @GetMapping("/create")
    public String add(Model model){
        model.addAttribute("church", new Church());
        return "formTemplate";
    }

    @Secured("ROLE_LIDER")
    @PostMapping("/saveChurch")
    public String saveChurch(@ModelAttribute("church") Church church, @RequestParam("foto") MultipartFile foto){
        churchService.save(church, foto);
        return "redirect:/";
    }

    @Secured("ROLE_LIDER")
    @PostMapping("/edit")
    public String edit(@RequestParam("id") Long id,Model model){
        Church church = new Church();
        church= churchService.findChurchById(id);
        model.addAttribute("church", church);
        return "modifyChurch";
    }

    @Secured("ROLE_LIDER")
    @PostMapping("/modifyChurch")
    public String saveEChurch(@ModelAttribute("church") Church church, @RequestParam("foto") MultipartFile foto,  @RequestParam("dirImg") String current){
        churchService.edit(church, foto, current);
        return "redirect:/";
    }


}
