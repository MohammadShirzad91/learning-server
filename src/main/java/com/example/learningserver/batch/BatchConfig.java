package com.example.learningserver.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {
    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public JobExecutionListener jobExecutionListener(){
        return new MyJobExecutionListener();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.afterPropertiesSet();
        return jobRepositoryFactoryBean.getObject();
    }
    @Bean
    public Job dbCardToFileJob(JobRepository jobRepository) throws Exception {
        return new JobBuilder("dbCardToFileJob", jobRepository)
                .start(step())
                .listener(jobExecutionListener())
                .build();
    }
    @Bean
    public Step step() throws Exception {
        return new StepBuilder("step", jobRepository())
                .<String, String>chunk(1, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
    @Bean
    public ItemReader itemReader(){
        return new MyReader();
    }
    @Bean
    public ItemProcessor itemProcessor(){
        return new MyProcessor();
    }
    @Bean
    public ItemWriter itemWriter(){
        return new MyWriter();
    }
}
