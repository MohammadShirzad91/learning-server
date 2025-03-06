package com.example.learningserver.service.service;

import com.example.learningserver.service.dao.CardDao;
import com.example.learningserver.service.data.CardEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardServiceImpl implements CardService{
    @Autowired
    private CardDao cardDao;

    @Override
    public void insertCard(CardEntity card) {
        cardDao.save(card);
    }

    @Override
    public CardEntity getCardByPan(String pan) {
        log.info("service is called");
        return cardDao.findById(pan).get();
    }
}
