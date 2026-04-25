package org.example.homeWorks.hw7.part2;

public class FraudCheckHandler extends LoanHandler {

    @Override
    protected boolean process(
            LoanApplication app
    ) {

        if(app.isFraudFlag()){

            app.setApproved(false);

            app.setDecisionReason(
                    "Rejected: fraud suspected"
            );

            return false;
        }

        return true;
    }
}