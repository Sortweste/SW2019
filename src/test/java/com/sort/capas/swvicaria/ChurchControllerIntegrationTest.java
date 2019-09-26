package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.controller.ChurchController;
import com.sort.capas.swvicaria.service.IChurchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//Fire up an application context that contains only the beans needed for testing a web controller:
@WebMvcTest(ChurchController.class)
public class ChurchControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;    //Simulates HTTP Requests

    @MockBean
    private IChurchService churchService;

    @Before
    public void SetUp(){

    }

    @Test
    public void s() throws Exception {
        //when().thenAnswer()
        mockMvc.perform(
                get("/Test/GetAllChurchs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
