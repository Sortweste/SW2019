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

@Controller
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
        /* Test */
        List<Church> list = new ArrayList<>();
        Church church = new Church();

        church.setName("Parroquia Monte Tabor");
        church.setHistory("inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially in the workplace. That’s why it’s crucial that, as women, our behavior on the job is beyond reproach. inappropriate behavior is often laughed.");
        church.setImg("/img/b1.jpg");
        /* Test */
        model.addAttribute("one",church);
        return "church";
    }
    @GetMapping("/group")
    public String showGroup(Model model) {
        /* Test */
        List<Church> list = new ArrayList<>();
        Church church = new Church();

        church.setName("Jovenes tabor");
        church.setHistory("inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially in the workplace. That’s why it’s crucial that, as women, our behavior on the job is beyond reproach. inappropriate behavior is often laughed.");
        church.setImg("/img/b3.jpg");
        /* Test */
        model.addAttribute("one",church);
        return "group";
    }

    /*
    @GetMapping("/error403")
    public String error403(Model model) {
        return "403";
    }


    @GetMapping("/error404")
    public String error404(Model model) {
        return "404";
    }*/

    @GetMapping("/error500")
    public String error500(Model model) {
        return "500";
    }
}

