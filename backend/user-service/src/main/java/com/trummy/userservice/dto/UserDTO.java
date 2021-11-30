package com.trummy.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    @Size(min = 5, max = 15, message = "Username must have between 5 and 15 characters")
    private String username;

    @NotBlank
    @Size(min = 5, max = 15, message = "Password must have between 5 and 15 characters")
    private String password;

}
