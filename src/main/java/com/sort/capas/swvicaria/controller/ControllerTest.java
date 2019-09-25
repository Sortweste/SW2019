package com.sort.capas.swvicaria.controller;

import com.sort.capas.swvicaria.domain.Church;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Test")
public class ControllerTest {

    @GetMapping("/")
    public String showAllchurch(Model model) {
        /* Test */
        List<Church> list = new ArrayList<>();
        Church church = new Church(null,null,null,null,null,null);

        //church
        church.setImg("/img/hotels/d1.jpg");
        church.setName("Judas");
        church.setHistory("la historia es muy larga para que un mortal como yo la cuente");
        church.setAddress("Santa Tecla");
        list.add(church);

        //church
        church = new Church(null,null,null,null,null,null);
        church.setImg("/img/hotels/d2.jpg");
        church.setName("Mateo");
        church.setHistory("Otra historia muy larga por lo cual se contara luego");
        church.setAddress("San Salvador");
        list.add(church);

        //church
        church = new Church(null,null,null,null,null,null);
        church.setImg("/img/hotels/d3.jpg");
        church.setName("Lucas");
        church.setHistory("ya no se que mas poner jajaja ando sin inspiracion");
        church.setAddress("Apopa");
        list.add(church);

        //church
        church = new Church(null,null,null,null,null,null);
        church.setImg("/img/hotels/d4.jpg");
        church.setName("Apocalipsis");
        church.setHistory("mueran pecadores jajajajaj XD");
        church.setAddress("San Salvador");
        list.add(church);

        /* Test */


        model.addAttribute("churchs",list);
        return "hotels";
    }



    @GetMapping("/church")
    public String showChurch(Model model) {
        /* Test */
        List<Church> list = new ArrayList<>();
        Church church = new Church(null,null,null,null,null,null);
        Church single = new Church(null,null,null,null,null,null);

        //church
        church.setImg("/img/hotels/d1.jpg");
        church.setName("Judas");
        church.setHistory("la historia es muy larga para que un mortal como yo la cuente");
        church.setAddress("Santa Tecla");
        list.add(church);

        //church
        church = new Church(null,null,null,null,null,null);
        church.setImg("/img/hotels/d2.jpg");
        church.setName("Mateo");
        church.setHistory("Otra historia muy larga por lo cual se contara luego");
        church.setAddress("San Salvador");
        list.add(church);

        //church
        church = new Church(null,null,null,null,null,null);
        church.setImg("/img/hotels/d3.jpg");
        church.setName("Lucas");
        church.setHistory("ya no se que mas poner jajaja ando sin inspiracion");
        church.setAddress("Apopa");
        list.add(church);

        //church
        single.setImg("/img/hotels/d4.jpg");
        single.setName("Apocalipsis");
        single.setHistory("mueran pecadores jajajajaj XD");
        single.setAddress("San Salvador");

        /* Test */


        model.addAttribute("ch",list);
        model.addAttribute("one",single);
        return "church";
    }
}

