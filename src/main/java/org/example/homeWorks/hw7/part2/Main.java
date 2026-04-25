package org.example.homeWorks.hw7.part2;

public class Main {

    public static void main(String[] args) {

        CreditPipeline pipeline =
                new CreditPipeline();


        LoanApplication app =
                LoanApplication.builder()
                        .fullName("Ramazan")
                        .age(30)
                        .income(2500)
                        .creditScore(720)
                        .requestedAmount(18000)
                        .fraudFlag(false)
                        .build();


        pipeline.process(app);

        System.out.println(
                "Approved: " + app.isApproved()
        );

        System.out.println(
                "Amount: " + app.getApprovedAmount()
        );

        System.out.println(
                app.getDecisionReason()
        );
    }
}