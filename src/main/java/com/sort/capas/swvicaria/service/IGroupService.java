package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Group;

import java.util.List;

public interface IGroupService {
    List<Group> findGroupsByChurch(long id);
    List<Group> findAll();
    Group save(Group group, long id);
    Group findGroup(long id);
}
