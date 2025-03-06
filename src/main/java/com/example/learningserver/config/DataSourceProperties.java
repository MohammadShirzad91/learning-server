package com.example.learningserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String dialect;
}
