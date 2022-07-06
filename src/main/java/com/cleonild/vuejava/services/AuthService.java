package com.cleonild.vuejava.services;

import com.cleonild.vuejava.dto.UserDTO;
import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void userRegister(User user) {
        this.userRepository.save(user);
    }

    public List<UserDTO> entitiesToDTO() {
        return this.userRepository.findAll().stream()
                .map(UserDTO::of).toList();
    }
}
