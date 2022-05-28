package com.example.timetracking.Liquibase.services;

import com.example.timetracking.Liquibase.models.entity.Role;
import com.example.timetracking.Liquibase.models.enums.ERole;
import com.example.timetracking.Liquibase.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findByName(ERole role) {
        return roleRepository.findByName(role);
    }
}