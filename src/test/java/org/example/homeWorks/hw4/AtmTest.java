package org.example.homeWorks.hw4;

import org.example.homeWorks.hw4.classes.AtmCellClass;
import org.example.homeWorks.hw4.classes.AtmClass;
import org.example.homeWorks.hw4.classes.BanknoteClass;
import org.example.homeWorks.hw4.enums.BankNoteValueEnum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtmTest {
    @Test
    void depositTest() {
        AtmCellClass cell1000 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.ONE_THOUSAND), 0);
        AtmCellClass cell500 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.FIVE_HUNDRED), 0);

        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of(cell1000, cell500))
                .balance(0)
                .build();

        atm.deposit(1500);

        assertEquals(1, cell1000.getCount());
        assertEquals(1, cell500.getCount());
        assertEquals(1500, atm.getBalance());
    }

    @Test
    void withdrawTest() {
        AtmCellClass cell1000 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.ONE_THOUSAND), 1);
        AtmCellClass cell500 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.FIVE_HUNDRED), 2);

        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of(cell1000, cell500))
                .balance(2000)
                .build();

        atm.withdraw(1500);

        assertEquals(0, cell1000.getCount());
        assertEquals(1, cell500.getCount());
        assertEquals(500, atm.getBalance());
    }

    @Test
    void depositShouldNotChangeStateWhenInvalidAmountTest() {
        AtmCellClass cell1000 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.ONE_THOUSAND), 0);
        AtmCellClass cell500 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.FIVE_HUNDRED), 0);

        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of(cell1000, cell500))
                .balance(0)
                .build();

        assertThrows(IllegalArgumentException.class, () -> atm.deposit(125));

        assertEquals(0, cell1000.getCount());
        assertEquals(0, cell500.getCount());
        assertEquals(0, atm.getBalance());
    }

    @Test
    void withdrawShouldThrowExceptionWhenNotEnoughBalanceTest() {
        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of())
                .balance(100)
                .build();

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(200));
    }

    @Test
    void withdrawShouldThrowExceptionWhenCannotComposeAmountTest() {
        AtmCellClass cell100 = new AtmCellClass(new BanknoteClass(BankNoteValueEnum.HUNDRED), 1);

        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of(cell100))
                .balance(100)
                .build();

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(50));
    }

    @Test
    void withdrawShouldThrowExceptionWhenNegativeAmountTest() {
        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of())
                .balance(1000)
                .build();

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(-100));
    }

    @Test
    void depositShouldThrowExceptionWhenNegativeAmountTest() {
        AtmClass atm = AtmClass.builder()
                .atmCellClasses(List.of())
                .balance(0)
                .build();

        assertThrows(IllegalArgumentException.class, () -> atm.deposit(-100));
    }
}

