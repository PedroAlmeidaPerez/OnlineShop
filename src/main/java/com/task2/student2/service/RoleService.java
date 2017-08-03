package com.task2.student2.service;

import com.task2.student2.model.UserRole;
import com.task2.student2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public List<UserRole> getAllRoles(){
        List<UserRole> rols = new ArrayList<>();
        roleRepository.findAll().forEach(rols::add);
        return rols;
    }

    public void addRole(UserRole userRole){
        roleRepository.save(userRole);
    }
}
