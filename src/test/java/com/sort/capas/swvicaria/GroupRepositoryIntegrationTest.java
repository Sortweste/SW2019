package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.repository.IGroupRepository;
import com.sort.capas.swvicaria.service.GroupServiceImpl;
import com.sort.capas.swvicaria.service.IGroupService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GroupServiceImpl.class})
public class GroupRepositoryIntegrationTest {

    @Autowired
    IGroupService iGroupService;

    @MockBean
    private IGroupRepository iGroupRepository;

    @Before
    public void SetUp(){

    }

}
