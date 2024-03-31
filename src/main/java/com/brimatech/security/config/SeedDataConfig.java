package com.brimatech.security.config;

import com.brimatech.security.user.models.Permission;
import com.brimatech.security.user.models.Role;
import com.brimatech.security.user.models.User;
import com.brimatech.security.user.repositories.PermissionRepository;
import com.brimatech.security.user.repositories.RoleRepository;
import com.brimatech.security.user.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class SeedDataConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    public SeedDataConfig(UserRepository userRepository, PasswordEncoder passwordEncoder, PermissionRepository permissionRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0 && permissionRepository.count() == 0) {

            Set<Permission> permissionsSet = new HashSet<>(permissionRepository.findAll());
            Role role = roleRepository.findByRoleName("admin");
            role.setPermissions(permissionsSet);

            User admin = new User();
            admin.setFirstName("admin");
            admin.setFirstName("admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setRoles((Set<Role>) role);
            admin.isEnabled();
            userRepository.save(admin);
            log.debug("created ADMIN user - {}", admin);
        }
    }
}
