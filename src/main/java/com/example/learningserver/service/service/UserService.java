package com.example.learningserver.service.service;

import com.example.learningserver.service.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<UserEntity, Long> {
}
