package org.example.homeWorks.hw7.part2;

public class IncomeHandler extends LoanHandler {

    @Override
    protected boolean process(
            LoanApplication app
    ) {

        double income = app.getIncome();

        if(income < 1000){

            app.setApproved(false);

            app.setDecisionReason(
                    "Rejected: income too low"
            );

            return false;
        }

        double maxLimit = income * 10;

        if(app.getRequestedAmount() > maxLimit){

            app.setApprovedAmount(maxLimit);

        } else {

            app.setApprovedAmount(
                    app.getRequestedAmount()
            );
        }

        return true;
    }
}