package com.ricardo.config;

import com.ricardo.persistence.InMemoryRepoStudents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReposConfig {
    @Bean
    public InMemoryRepoStudents crearBeanIMRepo() {
        return new InMemoryRepoStudents();
    }

}
