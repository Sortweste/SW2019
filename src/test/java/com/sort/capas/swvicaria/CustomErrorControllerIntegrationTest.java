package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.controller.CustomErrorController;
import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomErrorController.class)
public class CustomErrorControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;



    @Test
    @WithMockUser
    public void whenServerErrorFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                get("/error").contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(view().name("500"))
                .andExpect(status().isOk());
    }

    /*@Test
    @WithMockUser
    public void whenHandleErrorClientFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                get("/error").contentType(MediaType.APPLICATION_JSON)
                .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 404)

        )
                .andExpect(status().is(404));

    }*/


}
