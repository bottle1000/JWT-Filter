package org.example.jwtfilter.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.jwtfilter.user.model.request.LoginRequest;
import org.example.jwtfilter.user.model.response.LoginResponse;
import org.example.jwtfilter.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        String token  = userService.login(request);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
