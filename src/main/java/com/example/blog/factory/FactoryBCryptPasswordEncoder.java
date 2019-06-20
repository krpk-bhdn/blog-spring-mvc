package com.example.blog.factory;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class FactoryBCryptPasswordEncoder {
    private static BCryptPasswordEncoder passwordEncoder;

    private FactoryBCryptPasswordEncoder(){
    }

    public static PasswordEncoder getInstance(){
        if(passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }
}
