package com.example.learningserver.service.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "privileges")
@Data
@NoArgsConstructor
public class PrivilegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name; // e.g., "READ_PRIVILEGE", "WRITE_PRIVILEGE"

    @ManyToMany(mappedBy = "privileges")
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRoles(RoleEntity roleEntity) {
        roles.add(roleEntity);
    }
}
