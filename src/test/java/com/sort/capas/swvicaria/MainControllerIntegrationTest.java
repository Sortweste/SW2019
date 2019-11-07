package com.sort.capas.swvicaria;


import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.controller.MainController;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Test
    @WithMockUser
    public void whenAccessRootFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                get("/")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(redirectedUrl("/VicariaSW/Church"))
                .andExpect(status().is(302));
    }

    @Test
    @WithMockUser
    public void whenLoginFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                get("/login")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void whenInitFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                get("/VicariaSW/Church")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());


    }

}
