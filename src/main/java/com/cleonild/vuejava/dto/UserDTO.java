package com.cleonild.vuejava.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

}
