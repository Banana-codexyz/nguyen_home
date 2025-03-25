package com.nguyenz.demo1.service;

import com.nguyenz.demo1.dto.request.UserDTO;
import com.nguyenz.demo1.entity.Role;
import com.nguyenz.demo1.entity.User;
import com.nguyenz.demo1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }

    @Transactional
    public User saveUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists: " + userDTO.getUsername());
        }
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()));
        user = userRepository.save(user);

        Set<Role> roles = new HashSet<>();
        for (String roleName : userDTO.getRoles()) {
            Role role = roleService.findByName(roleName);
            roles.add(role);
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
