package com.example.spring.boot.security.springbootdemosecurity.controller;

import com.example.spring.boot.security.springbootdemosecurity.model.Role;
import com.example.spring.boot.security.springbootdemosecurity.model.User;
import com.example.spring.boot.security.springbootdemosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@Controller
class UserController {
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

    @PostMapping("/login")
    public String loginUser(Principal principal ) {
        System.out.println("PostMapping login was opened");
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        System.out.println("PostMapping userDetails clicked: "+userDetails.getUsername());
        System.out.println("PostMapping userDetails clicked: "+userDetails.getPassword());
        // model.addAttribute("name", name);
        return "redirect:/main";
    }

    @PostMapping("/main")
    public String showMainPage() {
        return "main";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        User userFromDB = userRepository.findUserByEmail(user.getEmail());
        if (userFromDB != null){
            model.addAttribute("info", "user already exists");
            return "registration";
        }
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setBirthday(user.getBirthday());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Collections.singleton(Role.USER));
        userRepository.save(newUser);
        model.addAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registration( ) {
        System.out.println("GetMapping register");
        return "registration";
    }

    @GetMapping("/users")
    public String getUsers( Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        return "userList";
    }
}
