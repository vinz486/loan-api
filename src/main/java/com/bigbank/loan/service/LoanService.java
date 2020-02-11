package com.bigbank.loan.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigbank.loan.engine.quote.LoanQuote;
import com.bigbank.loan.excetpion.InvalidLoanSubmissionException;
import com.bigbank.loan.model.LoanProposal;
import com.bigbank.loan.model.LoanSubmission;


@Component
public class LoanService extends AbstractService
{

    private static final String DEFAULT_CURRENCY_SIGN = "£";

    private static final Integer LOAN_AMOUNT_INCREMENT = 100;

    @Autowired
    private LoanEngineManager loanEngineManager;

    public LoanProposal calculate(LoanSubmission submission)
    {

        doFormalValidation(submission);

        LoanProposal.LoanProposalBuilder builder = LoanProposal.builder();

        builder.loanId(UUID.randomUUID().toString());
        builder.requestedAmount(String.valueOf(submission.getAmount()));

        LoanEngine loanEngine = loanEngineManager.buildEngine(submission.getMarket());

        LoanQuote quote = loanEngine.getQuote(submission);

        return render(quote, builder);
    }

    private LoanProposal render(LoanQuote quote, LoanProposal.LoanProposalBuilder builder)
    {

        builder.rate(quote.getRate().toPlainString());
        builder.monthlyRepayment(quote.getMonthlyRepayment().toPlainString());
        builder.totalRepayment(quote.getTotalRepayment().toPlainString());

        builder.currencySign(DEFAULT_CURRENCY_SIGN);

        return builder.build();
    }

    private void doFormalValidation(LoanSubmission submission)
    {

        if (submission.getAmount() % LOAN_AMOUNT_INCREMENT != 0)
        {
            throw new InvalidLoanSubmissionException("Amount must be in " + LOAN_AMOUNT_INCREMENT + " increments");
        }
    }
}
