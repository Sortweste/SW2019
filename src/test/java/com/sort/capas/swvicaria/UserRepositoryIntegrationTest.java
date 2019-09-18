package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.User;
import com.sort.capas.swvicaria.repository.IUserRepository;
import com.sort.capas.swvicaria.service.IUserService;
import com.sort.capas.swvicaria.service.UserServiceImpl;
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
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserRepositoryIntegrationTest {

    @Autowired
    private IUserService userService;

    @MockBean
    private IUserRepository userRepository;

    @Before
    public void setUp(){
        User user1 = new User();
        user1.setName("Lia");

        User user2 = new User();
        user2.setId((long) 1);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        when(userRepository.findUserByName(user1.getName())).thenReturn(user1);
        when(userRepository.findUserById(user2.getId())).thenReturn(user2);
        when(userRepository.findAll()).thenReturn(userList);

    }

    @Test
    public void whenFindByName_thenReturnUser(){
        String name = "Lia";
        User testUser = userService.findUserByName(name);
        Assert.assertEquals(testUser.getName(), name);
    }

    @Test
    public void whenFindById_thenReturnUser(){
        Long id = (long) 1;
        User testUser = userService.findUserById(id);
        Assert.assertEquals(testUser.getId(), id);
    }

    @Test
    public void whenFindAll_thenReturnList(){
        Assert.assertFalse(userService.findAll().isEmpty());
    }

}
