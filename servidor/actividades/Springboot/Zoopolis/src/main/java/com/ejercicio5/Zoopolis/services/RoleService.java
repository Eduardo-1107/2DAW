package com.ejercicio5.Zoopolis.services;

import com.ejercicio5.Zoopolis.models.Role;
import com.ejercicio5.Zoopolis.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    //TODO Borrar
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }
}
