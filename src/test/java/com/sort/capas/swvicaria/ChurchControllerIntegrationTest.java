package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.controller.ChurchController;
import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

        MultipartFile foto = new MockMultipartFile("foto","b","c","d".getBytes());

        when(iChurchService.findAll()).thenReturn(churches);
        when(iChurchService.save(church1, foto)).thenReturn(church1);
        when(iChurchService.findChurchById((long)1)).thenReturn(church1);
        when(iChurchService.save(new Church(),foto)).thenReturn(church2);
        when(iChurchService.edit(new Church(),foto,"")).thenReturn(church2);
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

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenAddChurchFromService_thenReturnStatus() throws Exception {
        List<Church> churches = new ArrayList<>();
        mockMvc.perform(
                get("/Church/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenEditChurchFromService_thenReturnStatus() throws Exception {

        mockMvc.perform(
                post("/Church/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                .param("id", String.valueOf(1))
                )
                .andDo(print())
                .andExpect(status().isOk());

        verify(iChurchService, times(1)).findChurchById((long)1);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void  whenSaveChurchFromService_thenReturnStatus() throws Exception{
        Church church = new Church();
        church.setId((long) 2);

        MockMultipartFile foto = new MockMultipartFile("foto","b","c","d".getBytes());

        mockMvc.perform(multipart("/Church/saveChurch")
                .file(foto)
                .flashAttr("church", church)
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        verify(iChurchService, times(1)).save(church, foto);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void  whenSaveChurchEFromService_thenReturnStatus() throws Exception{
        Church church = new Church();
        church.setId((long) 2);
        String testImg = "Test";
        church.setImg(testImg);

        MockMultipartFile foto = new MockMultipartFile("foto","b","c","d".getBytes());

        mockMvc.perform(multipart("/Church/modifyChurch")
                .file(foto)
                .flashAttr("church", church)
                .param("dirImg", church.getImg())
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        verify(iChurchService, times(1)).edit(church, foto, testImg);
    }

}
