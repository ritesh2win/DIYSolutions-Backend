package com.diysolutions.dto.authentication;

import com.diysolutions.enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private String securityQuestion;
    private String securityAnswer;

}