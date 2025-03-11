package com.example.learningserver.service.service;

import com.example.learningserver.service.dao.CardDao;
import com.example.learningserver.service.data.CardEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardDao cardDao;
    private final JobLauncher jobLauncher;
    private final Job dbCardToFileJob;

    @Override
    public void insertCard(CardEntity card) {
        cardDao.save(card);
    }

    @Override
    public CardEntity getCardByPan(String pan) {
        log.info("service is called");
        return cardDao.findById(pan).get();
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
