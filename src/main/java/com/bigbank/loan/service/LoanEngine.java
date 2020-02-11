package com.bigbank.loan.service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bigbank.loan.engine.quote.Lender;
import com.bigbank.loan.engine.quote.LoanQuote;
import com.bigbank.loan.engine.quote.LoanQuoteCalculator;
import com.bigbank.loan.model.LoanSubmission;


@Component
@Scope(SCOPE_PROTOTYPE)
public class LoanEngine
{
    private final String engineMarket;

    @Autowired
    private MarketDataSource marketDataSource;

    private LoanQuoteCalculator calculator;

    public LoanEngine(String market)
    {
        engineMarket = market;
    }

    @PostConstruct
    public void init()
    {
        List<Lender> lenders = marketDataSource.find(engineMarket);

        calculator = new LoanQuoteCalculator(lenders);
    }

    public LoanQuote getQuote(LoanSubmission submission)
    {
        return calculator.getQuote(submission.getAmount());
    }

}
