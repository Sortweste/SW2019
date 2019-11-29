package com.sort.capas.swvicaria;


import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.controller.AdminController;
import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupService;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @MockBean
    IChurchService iChurchService;

    @MockBean
    IGroupService iGroupService;

    @MockBean
    IEventService iEventService;

    @Before
    public void setUp(){
        List<Church> churches = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        Church church1 = new Church();
        Church church2 = new Church();

        Group group1 = new Group();
        group1.setId((long)1);

        Group group2 = new Group();

        Event event1 = new Event();
        Event event2 = new Event();

        churches.add(church1);
        churches.add(church2);

        groups.add(group1);
        groups.add(group2);

        events.add(event1);
        events.add(event2);

        when(iChurchService.findAll()).thenReturn(churches);
        when(iGroupService.findAll()).thenReturn(groups);
        when(iEventService.findAll()).thenReturn(events);
        when(iGroupService.findGroup((long) 1)).thenReturn(group1);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenChurchDashBoard_thenReturnStatus() throws Exception {
        mockMvc.perform(
                get("/Admin/Church")

        )
                .andDo(print())
                .andExpect(model().attribute("churches",hasSize(2)))
                .andExpect(status().isOk());

        verify(iChurchService, times(1)).findAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenGroupDashBoard_thenReturnStatus() throws Exception {
        mockMvc.perform(
                get("/Admin/Group")

        )
                .andDo(print())
                .andExpect(model().attribute("groups",hasSize(2)))
                .andExpect(status().isOk());

        verify(iGroupService, times(1)).findAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenEventDashBoard_thenReturnStatus() throws Exception {
        mockMvc.perform(
                get("/Admin/Event")

        )
                .andDo(print())
                .andExpect(model().attribute("events",hasSize(2)))
                .andExpect(status().isOk());

        verify(iEventService, times(1)).findAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenManageMembersByGroup_thenReturnStatus() throws Exception {
        mockMvc.perform(
                post("/Admin/Members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", String.valueOf(1))
        )
                .andDo(print())
                .andExpect(status().isOk());

        verify(iGroupService, times(1)).findGroup((long)1);
    }

}
