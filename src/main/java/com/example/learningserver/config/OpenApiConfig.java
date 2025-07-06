package com.example.learningserver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI CustomOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Learning Server")
                        .version("1.0")
                        .description("Learning Server services"));
    }
}
