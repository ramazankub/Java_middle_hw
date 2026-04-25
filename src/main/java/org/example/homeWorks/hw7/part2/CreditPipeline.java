package org.example.homeWorks.hw7.part2;

public class CreditPipeline {

    private final LoanHandler first;

    public CreditPipeline(){

        first = new AgeCheckHandler();

        first
                .setNext(
                        new CreditScoreHandler()
                )
                .setNext(
                        new FraudCheckHandler()
                )
                .setNext(
                        new IncomeHandler()
                )
                .setNext(
                        new FinalApprovalHandler()
                );
    }

    public void process(
            LoanApplication application
    ){
        first.handle(application);
    }
}