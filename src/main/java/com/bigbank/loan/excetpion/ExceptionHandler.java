package com.bigbank.loan.excetpion;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;


@ControllerAdvice
public class ExceptionHandler implements ProblemHandling
{
}
