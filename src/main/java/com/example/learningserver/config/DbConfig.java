package com.example.learningserver.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DbConfig {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Bean
    public DataSource dataSource(){
        try {
             return DataSourceBuilder.create()
                    .url(dataSourceProperties.getUrl())
                    .driverClassName(dataSourceProperties.getDriverClassName())
                    .username(dataSourceProperties.getUsername())
                    .password(dataSourceProperties.getPassword())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setJpaDialect(new HibernateJpaDialect());
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.example");
        em.setJpaVendorAdapter(jpaVendorAdapter());
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", dataSourceProperties.getDialect());
        em.setJpaPropertyMap(jpaProperties);
        return em;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }
}
