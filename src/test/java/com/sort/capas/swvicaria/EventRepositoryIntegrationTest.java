package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.Event;
import com.sort.capas.swvicaria.repository.IEventRepository;
import com.sort.capas.swvicaria.service.EventServiceImpl;
import com.sort.capas.swvicaria.service.IEventService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EventServiceImpl.class})
public class EventRepositoryIntegrationTest {

    @Autowired
    private IEventService iEventService;

    @MockBean
    private IEventRepository iEventRepository;

    @Before
    public void setUp(){
        Event event = new Event();
        event.setId((long)1);
        when(iEventRepository.save(any(Event.class))).thenReturn(event);
    }

    @Test
    public void whenSave_theReturnChurch() throws ParseException {
        Event ev = new Event();
        Long id = (long)1;
        ev.setId(id);

        Assert.assertEquals(iEventService.save(ev).getId(),ev.getId());
    }


}
