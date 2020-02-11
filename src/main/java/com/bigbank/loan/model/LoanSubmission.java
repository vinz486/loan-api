package com.bigbank.loan.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import lombok.Data;


@Data
public class LoanSubmission
{
    @NotBlank(message = "You must select a market name")
    String market;

    @NotNull(message = "You must provide a loan amount")
    @Range(min = 1000, max = 15000, message = "Loan amount must be in the 1000..15000 range")
    Integer amount;
}
