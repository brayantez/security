package com.brimatech.security.user.services;

import com.brimatech.security.user.dtos.CreateRoleDTO;
import com.brimatech.security.user.models.Role;
import com.brimatech.security.user.repositories.RoleRepository;
import com.brimatech.security.utils.ApiResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ApiResponse<Role> createRole(CreateRoleDTO createRoleDTO){
        ApiResponse<Role> apiResponse = new ApiResponse<>();
        Role role = new Role();
        role.setRoleName(createRoleDTO.getRoleName());
        Role role1 = roleRepository.save(role);
        apiResponse.setData(role1);
        apiResponse.setMessage("Role name created successfully");
        apiResponse.setTimestamp(Instant.now());
        return apiResponse;
    }
}
