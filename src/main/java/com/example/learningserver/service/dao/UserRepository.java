package com.example.learningserver.service.dao;

import com.example.learningserver.service.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
