package com.bigbank.loan.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoanProposal
{

    String loanId;

    String requestedAmount;

    String rate;

    String monthlyRepayment;

    String totalRepayment;

    String currencySign;
}
