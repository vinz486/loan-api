package com.bigbank.loan.model;

import java.util.List;

import com.bigbank.loan.engine.quote.Lender;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MarketLenders
{
    String market;
    List<Lender> lenders;
}
