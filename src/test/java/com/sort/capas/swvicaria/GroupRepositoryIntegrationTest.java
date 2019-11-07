package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import com.sort.capas.swvicaria.repository.IGroupRepository;
import com.sort.capas.swvicaria.service.GroupServiceImpl;
import com.sort.capas.swvicaria.service.IGroupService;
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
import static org.mockito.Mockito.any;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GroupServiceImpl.class})
public class GroupRepositoryIntegrationTest {

    @Autowired
    IGroupService iGroupService;

    @MockBean
    private IGroupRepository iGroupRepository;

    @MockBean
    private IChurchRepository iChurchRepository;

    @Before
    public void SetUp(){
        List<Group> GroupList = new ArrayList<>();
        Long id = (long) 1;
        Group group = new Group();
        group.setId(id);
        group.setName("Test Group");

        GroupList.add(group);

        when(iGroupRepository.findGroupsByChurch(iChurchRepository.findChurchById((long)1))).thenReturn(GroupList);
        when(iGroupRepository.save(any(Group.class))).thenReturn(group);
        when(iGroupRepository.findAll()).thenReturn(GroupList);
        when(iGroupRepository.findGroupById(id)).thenReturn(group);
    }

    @Test
    public void whenfindGroupsByChurch_thenReturnList(){
        Long id = (long)1;
        String name = "Test Group";
        Assert.assertFalse(iGroupService.findGroupsByChurch(id).isEmpty());
    }

    @Test
    public void whenFindAll_thenReturnList(){
        Assert.assertFalse(iGroupService.findAll().isEmpty());
    }

    @Test
    public void whenFindGroup_thenReturnGroup(){
        String name = "Test Group";
        Assert.assertEquals(iGroupService.findGroup((long) 1).getName(), name);
    }

    @Test
    public void whenSave_theReturnChurch(){
        Group group = new Group();
        Long id = (long)1;
        group.setId(id);

        Assert.assertEquals(iGroupService.save(group, id).getId(),group.getId());
    }


}
