package com.brimatech.security.user.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "role_name_unique",columnNames = "roleName")
        }
)
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "role_name",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "role_permission_role_id_fk")),
            inverseJoinColumns = @JoinColumn(name = "permission_id",foreignKey = @ForeignKey(name = "role_permission_permission_id_fk"))
    )
    private Set<Permission> permissions = new HashSet<>();

    public Role() {
    }

    public Role(String roleName, Set<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String name) {
        this.roleName = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }

//    USER(Collections.emptySet()),
//    ADMIN(Set.of(ADMIN_READ,ADMIN_UPDATE,ADMIN_DELETE,ADMIN_CREATE,MANAGER_READ,MANAGER_UPDATE,MANAGER_DELETE,MANAGER_CREATE)),
//    MANAGER(Set.of(MANAGER_READ,MANAGER_UPDATE,MANAGER_DELETE,MANAGER_CREATE));
//
//    @Getter
//    private final Set<Permission> permissions;
//
//    public List<SimpleGrantedAuthority> getAuthorities() {
//        var authorities = getPermissions()
//                .stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//                .collect(Collectors.toList());
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return authorities;
//    }
}
