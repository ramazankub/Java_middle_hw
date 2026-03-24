package org.example.homeWorks.hw4.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.homeWorks.hw4.enums.BankNoteValueEnum;

@AllArgsConstructor
@Getter
public class BanknoteClass {
    private final BankNoteValueEnum value;
}
