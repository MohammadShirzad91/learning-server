package com.example.learningserver.batch;

import com.example.learningserver.service.data.CardEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements ItemProcessor<CardEntity, String> {
    @Override
    public String process(CardEntity item) throws Exception {
        boolean isNotValid = item.getPan() == null || item.getCif() == null
                || item.getPaymentApplicationNumber() == null ||
                item.getPaymentApplicationType() == null;
        if (isNotValid)
            throw new RuntimeException("item is invalid");
        return item.toString();
    }
}
