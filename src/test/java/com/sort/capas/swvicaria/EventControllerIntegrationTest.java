package com.sort.capas.swvicaria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sort.capas.swvicaria.configuration.CustomLoginSuccessHandler;
import com.sort.capas.swvicaria.controller.EventController;
import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.service.IEventService;
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
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Before
    public void setUp() throws ParseException {
        Event event = new Event();

        event.setAuthor("Grupo A");
        event.setPersona("Lia");
        event.setInformation("Lorem Ipsum");
        event.setTime("16:00");
        event.setSub_author("A");
        event.setTitle("Evento 1");
        event.setDate_start(new Date());
        event.setCost(1000);
        event.setId((long)1);

        when(iEventService.save(event)).thenReturn(event);
    }

    @Test
    @WithMockUser(username = "admin", roles = {"LIDER"})
    public void whenGetAllChurchsFromService_thenReturnStatus() throws Exception {
        Event event = new Event();
        event.setAuthor("Grupo A");
        event.setPersona("Lia");
        event.setInformation("Lorem Ipsum");
        event.setTime("16:00");
        event.setSub_author("A");
        event.setTitle("Evento 1");
        event.setDate_start(new Date());
        event.setCost(1000);
        event.setId((long)1);

        ObjectMapper  objectMapper = new ObjectMapper();

        mockMvc.perform(
                post("/Event/saveEvent")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .param("author", "Grupo A")
                        .param("persona", "Lia")
                        .param("info", "Lorem Ipsum")
                        .param("time", "16:00")
                        .param("sub_author", "A")
                        .param("title", "Evento 1")
                        .param("date", "")
                        .param("cost", "1000")
                .content(objectMapper.writeValueAsString(event))
        )
                .andDo(print())
                .andExpect(status().is(201));

        verify(iEventService, times(1)).save(event);
    }


}
