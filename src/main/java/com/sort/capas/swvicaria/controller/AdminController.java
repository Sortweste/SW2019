package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    IChurchService iChurchService;

    @Autowired
    IGroupService iGroupService;

    @GetMapping("/Event")
    public String eventDashBoard(Model model){
        return "adminDashboard";
    }

    @GetMapping("/Church")
    public String churchDashBoard(Model model){
        model.addAttribute("churches", iChurchService.findAll());
        return "adminChurch";
    }

    @GetMapping("/Group")
    public String groupDashBoard(Model model){
        model.addAttribute("groups", iGroupService.findAll());
        return "adminGroup";
    }

    @PostMapping("/Group/Members")
    public String manageMembersByGroup(@RequestParam("id") Long id, Model model){
        model.addAttribute("members", iGroupService.findGroup(id).getUsers());
        return "adminGroup";
    }

}
