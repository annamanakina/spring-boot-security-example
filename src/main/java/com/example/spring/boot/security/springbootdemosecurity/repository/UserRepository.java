package com.example.spring.boot.security.springbootdemosecurity.repository;

import com.example.spring.boot.security.springbootdemosecurity.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserById(Integer id);
}
