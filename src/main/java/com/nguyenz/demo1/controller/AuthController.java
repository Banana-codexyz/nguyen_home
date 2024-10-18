package com.nguyenz.demo1.controller;

import com.nguyenz.demo1.dto.request.AuthRequest;
import com.nguyenz.demo1.dto.response.ApiResponse;
import com.nguyenz.demo1.dto.response.AuthResponse;
import com.nguyenz.demo1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    ApiResponse<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        AuthResponse result = authService.authenticate(request);
        return ApiResponse
                .<AuthResponse>builder()
                .result(result)
                .build();
    }
}
