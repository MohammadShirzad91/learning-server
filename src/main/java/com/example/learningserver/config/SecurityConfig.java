package com.example.learningserver.config;

import com.example.learningserver.service.repository.UserRepository;
import com.example.learningserver.service.data.PrivilegeEntity;
import com.example.learningserver.service.data.RoleEntity;
import com.example.learningserver.service.data.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**"
                ).permitAll()
                .anyRequest()
                .authenticated()).httpBasic().and().csrf().disable().build();
    }
    @Bean
    public CommandLineRunner initSecurityBasics(UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsById(1L)){
                UserEntity adminUser = new UserEntity();
                adminUser.setUsername("ADMIN");
                adminUser.setPassword("ADMIN");
                PrivilegeEntity adminPrivilege = new PrivilegeEntity();
                adminPrivilege.setName("ALL");
                RoleEntity adminRole = new RoleEntity();
                adminRole.setName("ROLE_ADMIN");
                adminRole.addPrivileges(adminPrivilege);
                adminUser.addRoles(adminRole);
                userRepository.save(adminUser);
            }
        };
    }
}
