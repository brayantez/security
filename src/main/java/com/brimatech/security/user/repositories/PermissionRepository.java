package com.brimatech.security.user.repositories;

import com.brimatech.security.user.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {


}
