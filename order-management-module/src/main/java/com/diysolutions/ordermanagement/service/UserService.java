package com.diysolutions.ordermanagement.service;

import com.diysolutions.dto.authentication.LoginRequest;
import com.diysolutions.dto.authentication.SignupRequest;
import com.diysolutions.entity.ordermanagement.User;
import com.diysolutions.enums.Role;
import com.diysolutions.ordermanagement.exception.UserException;
import com.diysolutions.ordermanagement.repo.UserRepository;
import com.diysolutions.ordermanagement.constants.ErrorMessages;
import com.diysolutions.ordermanagement.util.PasswordUtil;
import com.diysolutions.ordermanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signup(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(PasswordUtil.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole(request.getRole() != null ? request.getRole() : Role.USER);
        user.setSecurityQuestion(request.getSecurityQuestion());
        user.setSecurityAnswer(request.getSecurityAnswer());

        userRepository.save(user);
        return JwtUtil.generateToken(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserException(ErrorMessages.INVALID_CREDENTIALS));

        if (!PasswordUtil.matches(request.getPassword(), user.getPassword())) {
            throw new UserException(ErrorMessages.INVALID_CREDENTIALS);
        }

        return JwtUtil.generateToken(user);
    }
}
