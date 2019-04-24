package com.example.spring.boot.security.springbootdemosecurity;

import com.example.spring.boot.security.springbootdemosecurity.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //List<User> findByLastName(String lastName);
}
