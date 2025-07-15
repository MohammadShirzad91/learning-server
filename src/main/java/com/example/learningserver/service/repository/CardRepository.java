package com.example.learningserver.service.repository;

import com.example.learningserver.service.data.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, String> {
}
