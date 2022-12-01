package com.edu.jwtservice.repository;

import com.edu.jwtservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
     User findByUserNameAndPassword(String userName, String password);
}