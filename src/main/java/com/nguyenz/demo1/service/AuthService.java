package com.nguyenz.demo1.service;

import com.nguyenz.demo1.dto.request.AuthRequest;
import com.nguyenz.demo1.dto.response.AuthResponse;
import com.nguyenz.demo1.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public AuthResponse authenticate(AuthRequest request) {
        return null;
    }
    private String generateToken(User user) {
        return null;
    }
}
