package com.edu.jwtservice.config;

import com.edu.jwtservice.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}
