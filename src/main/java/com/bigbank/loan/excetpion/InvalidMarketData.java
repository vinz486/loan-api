package com.bigbank.loan.excetpion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class InvalidMarketData extends RuntimeException
{
    public InvalidMarketData()
    {
        super();
    }

    public InvalidMarketData(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidMarketData(String message)
    {
        super(message);
    }

    public InvalidMarketData(Throwable cause)
    {
        super(cause);
    }
}