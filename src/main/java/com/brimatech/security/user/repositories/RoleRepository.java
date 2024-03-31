package com.brimatech.security.user.repositories;

import com.brimatech.security.user.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findById(Long id);

    Role findByRoleName(String role);
}
