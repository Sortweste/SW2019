package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.controller.EventController;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.domain.GroupxEvent;
import com.sort.capas.swvicaria.service.IEventService;
import com.sort.capas.swvicaria.service.IGroupxEventService;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.util.Date;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IEventService iEventService;

    @MockBean
    IGroupxEventService iGroupxEventService;

    @MockBean
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Before
    public void setUp() throws ParseException {
        Event event = new Event();

        event.setAuthor(3);
        event.setPersona("Lia");
        event.setInformation("Lorem Ipsum");
        event.setTime("16:00");
        event.setSub_author(5);
        event.setTitle("Evento 1");
        event.setDate_start(new Date());
        event.setCost(1000);
        event.setId((long)1);

        GroupxEvent gxe = new GroupxEvent();
        gxe.setEvent(event);
        Group group = new Group();
        group.setId(Long.parseLong(String.valueOf(1)));
        gxe.setGroup2(group);


        when(iEventService.save(new Event())).thenReturn(event);
        when(iGroupxEventService.save(new GroupxEvent())).thenReturn(gxe);
    }


    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenGetAllChurchsFromService_thenReturnStatus() throws Exception {
        Event event = new Event();
        event.setAuthor(1);
        event.setPersona("Lia");
        event.setInformation("Lorem Ipsum");
        event.setTime("16:00");
        event.setSub_author(2);
        event.setTitle("Evento 1");
        event.setDate_start(new Date());
        event.setCost(1000);

        GroupxEvent gxe = new GroupxEvent();
        gxe.setEvent(event);
        Group group = new Group();
        group.setId(Long.parseLong(String.valueOf(1)));
        gxe.setGroup2(group);


        mockMvc.perform(
                post("/Event/saveEvent")
                        .param("author", String.valueOf(event.getAuthor()))
                        .param("persona",event.getPersona())
                        .param("info", event.getInformation())
                        .param("time", event.getTime())
                        .param("sub_author", String.valueOf(event.getSub_author()))
                        .param("title",event.getTitle())
                        //.param("date",event.getDate_start().toString())
                        .param("cost", String.valueOf(event.getCost()))
        )
                .andDo(print())
                .andExpect(status().is(201));

        //verify(iEventService, times(1)).save(event);
    }


}
