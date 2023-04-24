package com.photoshoot.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public Pbkdf2PasswordEncoder passwordEncoder() {
        String pepper = "pepper";
        int saltLength = 16;
        int hashIterations = 2000;
        int hashWidth = 256;
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(pepper, saltLength, hashIterations, hashWidth);
        encoder.setEncodeHashAsBase64(true);
        return encoder;
    }
}

