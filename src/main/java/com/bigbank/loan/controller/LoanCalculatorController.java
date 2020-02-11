package com.bigbank.loan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigbank.loan.model.LoanProposal;
import com.bigbank.loan.model.LoanSubmission;
import com.bigbank.loan.service.LoanService;


@RestController
public class LoanCalculatorController extends AbstractController
{
    @Autowired
    private LoanService loanService;

    @PostMapping("/loan")
    public LoanProposal calculateLoan(@Valid @RequestBody LoanSubmission submission)
    {
        return loanService.calculate(submission);
    }
}
