package org.example.homeWorks.hw7.part2;

public class AgeCheckHandler extends LoanHandler {

    @Override
    protected boolean process(
            LoanApplication app
    ) {

        if (app.getAge() < 18) {

            app.setApproved(false);
            app.setDecisionReason(
                    "Rejected: under age"
            );

            return false;
        }

        return true;
    }
}