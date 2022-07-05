package com.cleonild.vuejava.services;

import com.cleonild.vuejava.dto.UserDTO;
import com.cleonild.vuejava.models.User;
import com.cleonild.vuejava.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Bean
    private ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        modelMapper().map(user, UserDTO.class);

        return userDTO;
    }


}
