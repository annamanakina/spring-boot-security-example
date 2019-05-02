package com.example.spring.boot.security.springbootdemosecurity.controller;

import com.example.spring.boot.security.springbootdemosecurity.model.Role;
import com.example.spring.boot.security.springbootdemosecurity.model.User;
import com.example.spring.boot.security.springbootdemosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    @Qualifier("CustomUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

   @GetMapping("/main")

    public String main(Principal principal, Model model) {

        //https://www.baeldung.com/get-user-in-spring-security
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        userDetails.getAuthorities().forEach(System.out::println);
        model.addAttribute("name", userDetails.getUsername());
        return "main";
    }

    @GetMapping("/login")
    public String login( ) {
        System.out.println("GetMapping login was opened");
        return "login";
    }

    @PostMapping("/main")
    public String showMainPage(){
        return "main";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        User userFromDB = userRepository.findUserByEmail(user.getEmail());
        if (userFromDB != null){
            model.addAttribute("info", "user already exists");
            return "registration";
        }

        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registration( ) {
        return "registration";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUsers( Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        //userRepository.findAll().forEach(System.out::println);
        return "userList";
    }

    @GetMapping("/users/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUserById( @PathVariable String id, Model model) {
        User user1 = userRepository.findUserById(Integer.parseInt(id));
        System.out.println("getUserById: " + user1.getEmail());

        //model.addAttribute("info", "userDetails page "+ user1.getId());
        model.addAttribute("info", "userDetails page "+ user1.getEmail());
        model.addAttribute("user", user1);
        return "userDetails";
    }

    @PostMapping("/users/user/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateUser(@PathVariable String id, Model model) {
        User user1 = userRepository.findUserById(Integer.parseInt(id));
        System.out.println("PostMapping updateUser: " + user1.getEmail());

        model.addAttribute("infoUpdated", "userDetails page "+ user1.getId());
        model.addAttribute("info1", "User "+ user1.getEmail() + "have been updated.");
        //model.addAttribute("user", user1);
        return "userDetails";
    }


}
