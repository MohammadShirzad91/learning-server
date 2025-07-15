package com.example.learningserver.service.repository;

import com.example.learningserver.service.data.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Long> {
}
