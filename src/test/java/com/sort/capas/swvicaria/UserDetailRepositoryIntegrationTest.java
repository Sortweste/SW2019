package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.User;
import com.sort.capas.swvicaria.repository.IUserRepository;
import com.sort.capas.swvicaria.service.JpaUserDetailsService;
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
@ContextConfiguration(classes = {JpaUserDetailsService.class})
public class UserDetailRepositoryIntegrationTest {

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private IUserRepository iUserRepository;

    @Before
    public void setUp(){
        User user = new User();
        String username = "TestUsername";
        user.setUsername(username);

        when(iUserRepository.findByUsername(username)).thenReturn(user);
    }

    @Test
    public void whenLoadUserByUsername_thenReturnUserDetails(){
        User user = new User();
        user.setId((long)1);
        user.setUsername("TestUsername");
        Assert.assertEquals(jpaUserDetailsService.loadUserByUsername("TestUsername").getUsername(),user.getUsername());
    }

}
