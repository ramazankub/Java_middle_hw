package org.example.homeWorks.hw4.enums;

import lombok.Getter;

@Getter
public enum BankNoteValueEnum {
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private final int banknoteValue;

    BankNoteValueEnum(int banknoteValue) {
        this.banknoteValue = banknoteValue;
    }
}
