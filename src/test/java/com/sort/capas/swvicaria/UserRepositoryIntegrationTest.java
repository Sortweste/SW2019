package com.sort.capas.swvicaria;

import com.sort.capas.swvicaria.domain.Role;
import com.sort.capas.swvicaria.domain.User;
import com.sort.capas.swvicaria.repository.IRoleRepository;
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
import static org.mockito.Mockito.any;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserRepositoryIntegrationTest {

    @Autowired
    private IUserService userService;

    @MockBean
    IRoleRepository roleRepository;

    @MockBean
    private IUserRepository userRepository;

    @Before //Arrange
    public void setUp(){
        User user1 = new User();
        user1.setName("Lia");

        Role role_leader = new Role();
        Role role_member = new Role();
        Role role_user = new Role();

        role_leader.setId((long)1);
        role_member.setId((long)2);
        role_user.setId((long)3);

        user1.setRole(role_leader);

        User user2 = new User();
        user2.setId((long) 1);
        user2.setRole(role_member);

        User user3 = new User();
        user3.setRole(role_user);


        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);


        when(userRepository.findByUsername(user1.getName())).thenReturn(user1);
        when(userRepository.findUserById(user2.getId())).thenReturn(user2);
        when(userRepository.findAll()).thenReturn(userList);
        when(userRepository.saveAndFlush(any(User.class))).thenReturn(user1);

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

    @Test
    public void whenBecomeMember_thenReturnUser(){
        User user = new User();
        Role role = new Role();

        role.setId((long)2);

        user.setRole(role);
        user.setName("Lia");

        Assert.assertEquals(userService.becomeMember((long)1).getName(), user.getName());
    }

    @Test
    public void whenBecomeLeader_thenReturnUser(){
        User user = new User();
        Role role = new Role();

        role.setId((long)1);

        user.setRole(role);

        Assert.assertEquals(userService.becomeLeader((long)1).getRole(), user.getRole());
    }

    @Test
    public void whenBecomeUser_thenReturnUser(){
        User user = new User();
        Role role = new Role();

        role.setId((long)3);

        user.setRole(role);
        user.setName("Lia");

        Assert.assertEquals(userService.becomeUser((long)1).getName(), user.getName());
    }

}
