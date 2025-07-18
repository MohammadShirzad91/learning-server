package com.example.learningserver.batch;

import com.example.learningserver.service.repository.CardRepository;
import com.example.learningserver.service.data.CardEntity;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyReader implements ItemReader<CardEntity> {
    @Autowired
    private CardRepository cardRepository;
    private Optional<CardEntity> byId = Optional.empty();
    @Override
    public CardEntity read() throws UnexpectedInputException, ParseException, NonTransientResourceException {
        if(byId.isPresent()) {
            return null;
        }
        byId = cardRepository.findById("6219861067486752");
        System.out.println("read card from db " + byId);
        return byId.get();
    }
}
