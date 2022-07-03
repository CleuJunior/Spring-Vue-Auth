package com.cleonild.vuejava.controllers;

import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
