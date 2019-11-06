package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Role;
import com.sort.capas.swvicaria.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleRepository Role;

    @Override
    public Role findRolebyId(Long id) {
        return Role.findRoleById(id);
    }
}
