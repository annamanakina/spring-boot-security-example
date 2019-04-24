package com.example.spring.boot.security.springbootdemosecurity.controller;

import com.example.spring.boot.security.springbootdemosecurity.model.Role;
import com.example.spring.boot.security.springbootdemosecurity.model.User;
import com.example.spring.boot.security.springbootdemosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;

@Controller
public class GreetingController {
    @Autowired
    @Qualifier("CustomUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    private UserRepo userRepo;

    /*@ModelAttribute("user")
    private User user(){
        return new User();
    }*/

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
    public String add( Model model) {
        // model.addAttribute("name", name);
        return "main";
    }

    @PostMapping("/register")
    public String register(User user, Model model ) {
        System.out.println("PostMapping register getUsername: " + user.getUsername());
        System.out.println("PostMapping register getPassword: " + user.getPassword());
        //User userFromDB = userRepo.findUserByEmail(user.getEmail());
        User userFromDB = userRepo.findUserByUsername(user.getUsername());
        if (userFromDB != null){
            model.addAttribute("info", "user already exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        // model.addAttribute("name", name);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registration( ) {
        System.out.println("GetMapping register");
        // model.addAttribute("name", name);
        return "registration";
    }
}
