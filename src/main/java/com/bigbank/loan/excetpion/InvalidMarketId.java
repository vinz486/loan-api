package com.bigbank.loan.excetpion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidMarketId extends RuntimeException
{
    public InvalidMarketId()
    {
        super();
    }

    public InvalidMarketId(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidMarketId(String message)
    {
        super(message);
    }

    public InvalidMarketId(Throwable cause)
    {
        super(cause);
    }
}