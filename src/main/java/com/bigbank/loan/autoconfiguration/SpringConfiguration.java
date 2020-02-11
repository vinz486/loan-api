package com.bigbank.loan.autoconfiguration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;


@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class SpringConfiguration
{
    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper().registerModules(new ProblemModule(), new ConstraintViolationProblemModule());
    }
}
