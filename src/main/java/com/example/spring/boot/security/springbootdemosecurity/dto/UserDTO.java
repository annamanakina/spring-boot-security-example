package com.example.spring.boot.security.springbootdemosecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    //private String firstName;
    //private String lastName;
    private String username; //email
    private String password;
    private boolean active;
}
