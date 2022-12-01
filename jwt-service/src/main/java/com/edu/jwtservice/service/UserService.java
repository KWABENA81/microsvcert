package com.edu.jwtservice.service;

import com.edu.jwtservice.exception.UserNotFoundException;
import com.edu.jwtservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}