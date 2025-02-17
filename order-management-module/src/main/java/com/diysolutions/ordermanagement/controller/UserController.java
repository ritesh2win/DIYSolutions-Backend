package com.diysolutions.ordermanagement.controller;


import com.diysolutions.dto.authentication.LoginRequest;
import com.diysolutions.dto.authentication.SignupRequest;
import com.diysolutions.ordermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "User Authentication", description = "Endpoints for user login and signup")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @Operation(summary = "User Signup", description = "Registers a new user and returns a JWT token")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        String token = userService.signup(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Logs in the user and returns a JWT token")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(token);
    }
}
