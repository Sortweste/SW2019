package com.sort.capas.swvicaria;


import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.controller.GroupController;
import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IGroupService;
import com.sort.capas.swvicaria.service.IUserService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
public class GroupControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IGroupService iGroupService;

    @MockBean
    private IChurchService churchService;

    @MockBean
    private IUserService userService;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;


    @Before
    public void setUp(){
        List<Group> groups = new ArrayList<>();
        List<Church> churches = new ArrayList<>();

        Group group1 = new Group();
        group1.setId((long)1);

        Group group2 = new Group();
        Church church = new Church();
        church.setId((long)2);

        churches.add(church);

        groups.add(group1);
        groups.add(group2);

        when(iGroupService.findAll()).thenReturn(groups);
        when(iGroupService.findGroupsByChurch((long)1)).thenReturn(groups);
        when(iGroupService.findGroup((long)1)).thenReturn(group1);
        when(churchService.findAll()).thenReturn(churches);
        when(iGroupService.save(new Group(), (long) 2)).thenReturn(group2);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenGetAllGroupsFromService_thenReturnStatus() throws Exception {
        List<Group> groups = new ArrayList<>();
        mockMvc.perform(
                get("/Group/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("groups",hasSize(2)));

        verify(iGroupService, times(1)).findAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenshowGroupsFromService_thenReturnStatus() throws Exception {
        List<Group> groups = new ArrayList<>();
        mockMvc.perform(
                post("/Group/showByChurch")
                        .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("groups",hasSize(2)));

        verify(iGroupService, times(1)).findGroupsByChurch((long)1);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenshowGroupFromService_thenReturnStatus() throws Exception {
        mockMvc.perform(
                post("/Group/showGroup")
                        .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("group", hasProperty("id", equalTo((long)1))));

        verify(iGroupService, times(1)).findGroup((long)1);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenAddGroupFromService_thenReturnStatus() throws Exception {
        mockMvc.perform(
                get("/Group/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        verify(churchService, times(1)).findAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void  whenSaveGroupFromService_thenReturnStatus() throws Exception{
        Group group = new Group();
        group.setId((long) 2);
        mockMvc.perform(
                post("/Group/saveGroup").param("Churchid", String.valueOf(group.getId()))
                .flashAttr("group", group)
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        verify(iGroupService, times(1)).save(group, (long) 2);
    }

}
