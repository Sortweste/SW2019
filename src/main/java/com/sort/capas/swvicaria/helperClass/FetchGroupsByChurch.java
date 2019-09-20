package com.sort.capas.swvicaria.helperClass;

import com.sort.capas.swvicaria.domain.Group;
import com.sort.capas.swvicaria.service.IChurchService;
import com.sort.capas.swvicaria.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FetchGroupsByChurch {

    @Autowired
    private IChurchService churchService;

    @Autowired
    private IGroupService iGroupService;

    public FetchGroupsByChurch(){}

    protected List<Group> GetGroupsListByChurch(Long id){
        return iGroupService.findGroupsByChurch(churchService.findChurchById(id));
    }
}
