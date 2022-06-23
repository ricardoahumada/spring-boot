package com.ricardo.config;

import com.ricardo.persistence.InMemoryRepoStudents;
import com.ricardo.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import({ReposConfig.class, ServicesConfig.class})
public class SpringConfig {

    /*@Bean
    public InMemoryRepoStudents crearBeanIMRepo() {
        return new InMemoryRepoStudents();
    }

    @Autowired
    @Lazy
    private InMemoryRepoStudents repoStd;

    @Bean
    public StudentsServices crearBeanStudentService() {
        StudentsServices sts = new StudentsServices();
        sts.setRepo(repoStd);
        return sts;
    }*/
}
