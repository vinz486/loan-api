package com.bigbank.loan.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


@Component
public abstract class LoanEngineManager
{
    public LoanEngine getEngine(String market)
    {
        return buildEngine(market);
    }

    @Lookup
    public abstract LoanEngine buildEngine(String market);
}
