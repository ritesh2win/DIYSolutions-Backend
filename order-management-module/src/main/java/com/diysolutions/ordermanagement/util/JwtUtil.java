package com.diysolutions.ordermanagement.util;

import com.diysolutions.entity.ordermanagement.User;
import com.diysolutions.ordermanagement.service.JwtService;

public class JwtUtil {
    private static final JwtService jwtService = new JwtService(); // Ensure it's properly injected if needed

    public static String generateToken(User user) {
        return jwtService.generateToken(user);
    }
}
