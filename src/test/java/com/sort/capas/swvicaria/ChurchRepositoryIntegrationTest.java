package com.sort.capas.swvicaria;


import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import com.sort.capas.swvicaria.service.ChurchServiceImpl;
import com.sort.capas.swvicaria.service.IChurchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ChurchServiceImpl.class})
public class ChurchRepositoryIntegrationTest {

    @Autowired
    IChurchService iChurchService;

    @MockBean
    IChurchRepository iChurchRepository;

    @Before
    public void SetUp(){
        List<Group> groups = new ArrayList<>();
        Church church1 = new Church((long) 1, "TestChurch", "","","",groups);
        when(iChurchRepository.findChurchById(church1.getId())).thenReturn(church1);
    }

    @Test
    public void whenFindGroupsByChurch_thenReturnGroupList(){
        Assert.assertFalse(iChurchService.findChurchById((long)1).getGroups().isEmpty());
    }

}
