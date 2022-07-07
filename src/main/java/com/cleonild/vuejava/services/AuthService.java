package com.cleonild.vuejava.services;

import com.cleonild.vuejava.dto.UserDTO;
import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void userRegister(User user) {
        UserDTO userDTO = UserDTO.of(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                passwordEncoder.encode(user.getPassword())
        );

        User userSaveEntity = User.of(userDTO);

        this.userRepository.save(userSaveEntity);
    }

    public List<UserDTO> entitiesToDTO() {
        return this.userRepository.findAll().stream()
                .map(UserDTO::of).toList();
    }
}
