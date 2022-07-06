package com.cleonild.vuejava.controllers;

import com.cleonild.vuejava.dto.UserDTO;
import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/users")
    public List<UserDTO> showListOfUsers() {
        return this.authService.entitiesToDTO();
    }

    @PostMapping(value = "/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {

        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");

        User user = User.of(userDTO);

        this.authService.userRegister(user);

        return userDTO;

    }
}
