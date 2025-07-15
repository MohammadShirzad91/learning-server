package com.example.learningserver.service.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name; // e.g., "ROLE_ADMIN"

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id")
    )
    private Set<PrivilegeEntity> privileges = new HashSet<>();

    public void addPrivileges(PrivilegeEntity privilege) {
        privileges.add(privilege);
    }
}
