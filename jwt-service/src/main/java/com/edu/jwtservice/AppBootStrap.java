package com.edu.jwtservice;

import com.edu.jwtservice.model.User;
import com.edu.jwtservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppBootStrap implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    public AppBootStrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String...arg) {
        userRepository.save(new User("edu", "pass234"));
        userRepository.save(new User("sask", "pass1234"));
    }
}
