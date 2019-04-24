package com.example.spring.boot.security.springbootdemosecurity.servie;

import com.example.spring.boot.security.springbootdemosecurity.model.Role;
import com.example.spring.boot.security.springbootdemosecurity.model.User;
import com.example.spring.boot.security.springbootdemosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepo.findUserByUsername(s);
        Set<Role> roles = user.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
           authorities.add(new SimpleGrantedAuthority(role.name()));
        }

        //2nd
        Set<SimpleGrantedAuthority> authorities2 =
                roles.stream()
                        .map(Role::name)
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities2);
    }
}
