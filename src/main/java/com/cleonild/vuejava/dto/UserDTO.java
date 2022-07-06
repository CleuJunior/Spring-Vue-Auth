package com.cleonild.vuejava.dto;

import com.cleonild.vuejava.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {

    @JsonProperty("first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @JsonProperty("last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @NotBlank
    @JsonProperty(value = "confirm_password", access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;

    private UserDTO(String firstName, String lastName, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private UserDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static UserDTO of(String firstName, String lastName, String email, String password, String confirmPassword) {
        return new UserDTO(firstName, lastName, email, password, confirmPassword);
    }

    public static UserDTO of(User user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail());
    }

}
