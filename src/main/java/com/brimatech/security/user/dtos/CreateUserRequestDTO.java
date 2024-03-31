package com.brimatech.security.user.dtos;

import com.brimatech.security.user.models.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequestDTO {

    @NotNull(message = "First Name is required to complete request")
    private String firstName;

    @NotNull(message = "Last Name is required to complete request")
    private String lastName;

    @Email
    @NotNull(message = "Email is required to complete request")
    private String email;

    @NotNull(message = "password is required to complete request")
    private String password;

    @NotNull(message = "role is required to complete request")
    private Set<Role> role;
}
