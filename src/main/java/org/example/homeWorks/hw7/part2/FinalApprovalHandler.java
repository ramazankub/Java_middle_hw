package org.example.homeWorks.hw7.part2;

public class FinalApprovalHandler extends LoanHandler {

    @Override
    protected boolean process(
            LoanApplication app
    ) {

        app.setApproved(true);

        app.setDecisionReason(
                "Approved"
        );

        return true;
    }
}