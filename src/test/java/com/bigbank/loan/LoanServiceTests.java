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


@ExtendWith(MockitoExtension.class)
@DisplayName("Testing LoanService")
class LoanServiceTests
{

    @InjectMocks
    LoanService testedLoanService;

    @Test
    void testFormalValidation()
    {

        /* Prepare */
        LoanSubmission loanSubmission = new LoanSubmission();
        loanSubmission.setAmount(1234);

        /* Execute */
        assertThatThrownBy(() -> testedLoanService.calculate(loanSubmission))

                /* Verify */
                .isInstanceOf(InvalidLoanSubmissionException.class)
                .hasMessageContaining("increments");

    }
}
