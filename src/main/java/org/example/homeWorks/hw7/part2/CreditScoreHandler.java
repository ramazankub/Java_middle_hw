package org.example.homeWorks.hw7.part2;

public class CreditScoreHandler extends LoanHandler {

    @Override
    protected boolean process(
            LoanApplication app
    ) {

        if(app.getCreditScore() < 500){

            app.setApproved(false);

            app.setDecisionReason(
                    "Rejected: bad credit score"
            );

            return false;
        }

        return true;
    }
}