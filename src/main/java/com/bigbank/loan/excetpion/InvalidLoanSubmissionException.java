package com.bigbank.loan.excetpion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidLoanSubmissionException extends RuntimeException
{
    public InvalidLoanSubmissionException()
    {
        super();
    }

    public InvalidLoanSubmissionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidLoanSubmissionException(String message)
    {
        super(message);
    }

    public InvalidLoanSubmissionException(Throwable cause)
    {
        super(cause);
    }
}