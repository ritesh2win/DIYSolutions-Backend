package com.diysolutions.dto.authentication;

import com.diysolutions.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private RoleEnum role;
}