package com.brimatech.security.user.models;

import jakarta.persistence.*;
@Entity
@Table(
        name = "permissions",
        uniqueConstraints = {
                @UniqueConstraint(name = "permission_name_unique",columnNames = "permissionName")
        }
)
public class Permission {

    @Id
    @SequenceGenerator(
            name = "permission_sequence",
            sequenceName = "permission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "permission_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "permission_name",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String permissionName;

    public Permission() {
    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }


//    ADMIN_READ("admin:read"),
//    ADMIN_UPDATE("admin:update"),
//    ADMIN_CREATE("admin:create"),
//    ADMIN_DELETE("admin:delete"),
//    MANAGER_READ("management:read"),
//    MANAGER_UPDATE("management:update"),
//    MANAGER_CREATE("management:create"),
//    MANAGER_DELETE("management:delete");
//
//    @Getter
//    private final String permission;

}
