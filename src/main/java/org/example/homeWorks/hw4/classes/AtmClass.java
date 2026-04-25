package org.example.homeWorks.hw4.classes;

import lombok.*;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Builder
public class AtmClass {
    @NonNull
    List<AtmCellClass> atmCellClasses;
    private int balance;

    public List<AtmCellClass> getSortedAtmCellClasses() {

        return this.atmCellClasses.stream()
                .sorted(Comparator.comparing((AtmCellClass n) -> n.getBanknote().getValue().getBanknoteValue())
                        .reversed())
                .toList();
    }

    public void deposit(int amount) {
        List<AtmCellClass> sortedList = getSortedAtmCellClasses();
        int initialAmount = amount;

        if (sortedList == null || sortedList.isEmpty() || amount <= 0) {
            throw new IllegalArgumentException("Указанная сумма недоступна к вводу");
        }

        List<Integer> originalCounts = sortedList.stream().map(AtmCellClass::getCount).toList();
        try {

            for (AtmCellClass atmCellClass : sortedList) {
                int value = atmCellClass.getBanknote().getValue().getBanknoteValue();
                int temp = amount / value;

                if (temp > 0) {
                    atmCellClass.setCount(atmCellClass.getCount() + temp);
                }
                amount = amount % value;

            }
            if (amount != 0) {
                throw new IllegalArgumentException("Введена неверная сумма");
            }
            setBalance(this.balance + initialAmount);

        } catch (IllegalArgumentException e) {
            for (int i = 0; i < sortedList.size(); i++) {
                sortedList.get(i).setCount(originalCounts.get(i));
            }
            throw e;
        }
    }

    public void withdraw(int amount) {
        List<AtmCellClass> sortedList = getSortedAtmCellClasses();
        int requestedAmount = amount;

        if (sortedList == null || sortedList.isEmpty() || amount <= 0 || requestedAmount > this.balance) {
            throw new IllegalArgumentException("Введите корректную сумму для снятия");
        }

        List<Integer> originalCounts = sortedList.stream().map(AtmCellClass::getCount).toList();

        try {
            for (AtmCellClass atmCellClass : sortedList) {
                int value = atmCellClass.getBanknote().getValue().getBanknoteValue();
                int count = atmCellClass.getCount();
                int temp = amount / value;

                int canTake = Math.min(count, temp);

                if (canTake > 0) {
                    atmCellClass.setCount(count - canTake);
                }

                amount -= canTake * value;
            }
            if (amount != 0) {
                throw new IllegalArgumentException("Данная сумма недоступна к выдаче. Повторите ввод.");
            }
            setBalance(this.balance - requestedAmount);
        } catch (IllegalArgumentException e) {
            for (int i = 0; i < sortedList.size(); i++) {
                sortedList.get(i).setCount(originalCounts.get(i));
            }
            throw e;
        }
    }
}
