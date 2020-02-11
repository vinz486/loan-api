package com.bigbank.loan.excetpion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class InsufficientLendersException extends RuntimeException
{
    public InsufficientLendersException()
    {
        super();
    }

    public InsufficientLendersException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InsufficientLendersException(String message)
    {
        super(message);
    }

    public InsufficientLendersException(Throwable cause)
    {
        super(cause);
    }
}