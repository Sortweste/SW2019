package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.controller.ChurchController;
import com.sort.capas.swvicaria.controller.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;



@RunWith(SpringRunner.class)
//Fire up an application context that contains only the beans needed for testing a web controller:
@WebMvcTest(ChurchController.class)
public class ChurchControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;    //Simulates HTTP Requests

    @MockBean
    private  IChurchService iChurchService;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;


    @Before
    public void SetUp(){

        List<Church> churches = new ArrayList<>();

        Church church1 = new Church();
        Church church2 = new Church();

        churches.add(church1);
        churches.add(church2);

        when(iChurchService.findAll()).thenReturn(churches);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenGetAllChurchsFromService_thenReturnStatus() throws Exception {
        List<Church> churches = new ArrayList<>();
        mockMvc.perform(
                get("/Church/")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("churchs",hasSize(2)));

        verify(iChurchService, times(1)).findAll();
    }
}
