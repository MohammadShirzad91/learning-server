package com.example.learningserver.service.service;

import com.example.learningserver.service.repository.CardRepository;
import com.example.learningserver.service.data.CardEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final JobLauncher jobLauncher;
    private final Job dbCardToFileJob;

    @Override
    public void insertCard(CardEntity card) {
        cardRepository.save(card);
    }

    @Override
    public CardEntity getCardByPan(String pan) {
        log.info("service is called");
        return cardRepository.findById(pan).orElse(null);
    }

    @Override
    public void writeCardOnFile(String pan) {
        JobParameters jobParameters = new JobParametersBuilder().addString("pan", pan).toJobParameters();
        try {
            jobLauncher.run(dbCardToFileJob, jobParameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
