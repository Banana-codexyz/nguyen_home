package com.nguyenz.demo1.service;

import com.nguyenz.demo1.entity.Role;
import com.nguyenz.demo1.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found: " + name));
    }


    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
