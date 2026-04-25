package org.example.homeWorks.hw7.part2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanApplication {

    private String fullName;

    private int age;

    private double income;

    private int creditScore;

    private double requestedAmount;

    private boolean fraudFlag;

    private boolean approved;

    private String decisionReason;

    private double approvedAmount;
}