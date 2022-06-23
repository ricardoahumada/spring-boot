package com.ricardo.config;

import com.ricardo.persistence.InMemoryRepoStudents;
import com.ricardo.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {
    @Autowired
    InMemoryRepoStudents repoStd;

    @Bean
    public StudentsServices crearBeanStudentService() {
        StudentsServices sts = new StudentsServices();
        sts.setRepo(repoStd);
        return sts;
    }

}
