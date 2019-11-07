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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ChurchServiceImpl.class})
public class ChurchRepositoryIntegrationTest {

    @Autowired
    IChurchService iChurchService;

    @MockBean
    IChurchRepository iChurchRepository;

    @Before
    public void SetUp(){
        List<Church> churches = new ArrayList<>();

        List<Group> groups = new ArrayList<>();
        Church church1 = new Church((long) 1, "TestChurch", "","","",groups);
        churches.add(church1);

        when(iChurchRepository.findChurchById(church1.getId())).thenReturn(church1);
        when(iChurchRepository.findAll()).thenReturn(churches);
        when(iChurchRepository.save(any(Church.class))).thenReturn(church1);
    }

    @Test
    public void whenFindChurchById_thenReturnChurch(){
        Long id = (long) 1;
        Church church = iChurchService.findChurchById(id);
        Assert.assertEquals(church.getId(),id);
    }

    @Test
    public void whenFindAll_thenReturnList(){
        Assert.assertFalse(iChurchService.findAll().isEmpty());
    }

    @Test
    public void whenSave_theReturnChurch(){
        Church church =  new Church();
        church.setId((long)1);
        MultipartFile foto = new MockMultipartFile("a","b","c","d".getBytes());
        Assert.assertEquals(iChurchService.save(church, foto).getId(),church.getId());
    }
}
