package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import com.sort.capas.swvicaria.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    IGroupRepository iGroupRepository;

    @Autowired
    IChurchRepository ChurchRepo;

    @Override
    public List<Group> findGroupsByChurch(long id) {
        Church church= ChurchRepo.findChurchById(id);
        return iGroupRepository.findGroupsByChurch(church);
    }

    @Override
    public List<Group> findAll() {
        return iGroupRepository.findAll();
    }

    @Override
    @Transactional
    public Group save(Group group, long id) {
        Group grupo=new Group();
        grupo.setName(group.getName());
        grupo.setInformation(group.getInformation());
        grupo.setSchedule(group.getSchedule());
        grupo.setChurch(ChurchRepo.findChurchById(id));
        return iGroupRepository.save(grupo);
    }

    @Override
    public Group findGroup(long id) {
        return iGroupRepository.findGroupById(id);
    }
}
