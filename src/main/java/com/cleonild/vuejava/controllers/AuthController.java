package com.cleonild.vuejava.controllers;

import com.cleonild.vuejava.dto.UserDTO;
import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.repositories.UserRepository;
import com.cleonild.vuejava.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final UserService userService;


    @PostMapping(value = "/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {

        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");

        User user = User.of(userDTO);

        this.userRepository.save(user);

        return userDTO;

    }
}
