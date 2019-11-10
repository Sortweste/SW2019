package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.GroupxEvent;
import com.sort.capas.swvicaria.repository.IGroupxEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupxEventServiceImpl implements IGroupxEventService {

    @Autowired
    IGroupxEventRepository iGroupxEventRepository;


    @Override
    @Transactional
    public GroupxEvent save(GroupxEvent gxe) {
        return iGroupxEventRepository.save(gxe);
    }
}
