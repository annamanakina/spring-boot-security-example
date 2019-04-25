package com.example.spring.boot.security.springbootdemosecurity.service;

import com.example.spring.boot.security.springbootdemosecurity.model.Role;
import com.example.spring.boot.security.springbootdemosecurity.model.User;
import com.example.spring.boot.security.springbootdemosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        //User user = userRepo.findUserByUsername(username);
        User user = userRepo.findUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);

        Set<Role> roles = user.getRoles();
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
           authorities.add(new SimpleGrantedAuthority(role.name()));
        }

        //2nd
        Set<SimpleGrantedAuthority> authorities2 =
                roles.stream()
                        .map(Role::name)
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities2);
    }
}
