package com.example.learningserver.service.dao;

import com.example.learningserver.service.data.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
