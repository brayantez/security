package com.brimatech.security.user.controllers;

import com.brimatech.security.user.dtos.ChangePasswordRequestDTO;
import com.brimatech.security.user.dtos.CreateRoleDTO;
import com.brimatech.security.user.dtos.CreateUserRequestDTO;
import com.brimatech.security.user.services.RoleService;
import com.brimatech.security.user.services.UserService;
import com.brimatech.security.utils.ApiResponse;
import com.brimatech.security.auth.dtos.AuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("create-user")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> registerUser(@RequestBody @Valid CreateUserRequestDTO createUserRequestDTO){
        log.info("Request for user creation : {}", createUserRequestDTO);
        ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();
        AuthenticationResponse userResponseDTO = userService.createUser(createUserRequestDTO);
        if(userResponseDTO == null){
            apiResponse.setStatus(ApiResponse.Status.FAILED);
            apiResponse.setMessage("Failed");
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        apiResponse.setData(userResponseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequestDTO request, Principal connectedUser) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("create-roles")
    public ResponseEntity<ApiResponse<?>> createRoles(@RequestBody @Valid CreateRoleDTO createRoleDTO){
        log.info("Request for role creation : {}", createRoleDTO);
        ApiResponse<?> apiResponse = roleService.createRole(createRoleDTO);

        return new ResponseEntity<>(apiResponse,
                apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


}
