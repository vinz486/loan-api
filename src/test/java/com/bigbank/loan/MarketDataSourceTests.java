package com.bigbank.loan;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bigbank.loan.excetpion.InvalidLoanSubmissionException;
import com.bigbank.loan.model.LoanSubmission;
import com.bigbank.loan.service.LoanService;
import com.bigbank.loan.service.MarketDataSource;


@ExtendWith(MockitoExtension.class)
@DisplayName("Testing MarketDataSource")
class MarketDataSourceTests
{

    @InjectMocks
    MarketDataSource testedMarketDataSource;

    @Test
    void testInvalidSource()
    {

        /* Prepare */
       String market = "BAD_MARKET";

        /* Execute */
        assertThatThrownBy(() -> testedMarketDataSource.find(market))

                /* Verify */
                .isInstanceOf(IllegalArgumentException.class);
    }
}
