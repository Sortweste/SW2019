package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.Role;
import com.sort.capas.swvicaria.repository.IRoleRepository;
import com.sort.capas.swvicaria.service.IRoleService;
import com.sort.capas.swvicaria.service.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RoleServiceImpl.class})
public class RoleRepositoryIntegrationTest {

    @Autowired
    private IRoleService iRoleService;

    @MockBean
    private IRoleRepository iRoleRepository;

    @Before
    public void setUp(){
        Role role = new Role();
        role.setId((long)1);
        when(iRoleRepository.findRoleById((long)1)).thenReturn(role);
    }

    @Test
    public void whenFindRoleById_thenReturnRole(){
        Role role = new Role();
        role.setId((long)1);
        Assert.assertEquals(iRoleService.findRolebyId((long)1).getId(), role.getId());
    }

}
