package com.example.learningserver.service.service;

import com.example.learningserver.service.data.CardEntity;

public interface CardService {
    void insertCard(CardEntity card);
    CardEntity getCardByPan(String pan);
}
