package com._05_validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignupRequest {
    private String userName;
    private String password;
    private String email;
    private String confirmPassword;
    private int age;

}

