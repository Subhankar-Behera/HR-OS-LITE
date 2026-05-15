package com.clogicsoftech.hroslite.auth.dto;

import com.clogicsoftech.hroslite.auth.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String name;

    private String email;

    private String password;

    private Role role;
}