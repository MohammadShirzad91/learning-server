package com.example.learningserver.service.dao;

import com.example.learningserver.service.data.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao  extends JpaRepository<CardEntity, String> {
}
