package org.example.homeWorks.hw2;

public class BouncerClass {

    boolean canEnter(boolean isFriday,
                     boolean isClothesSuitable,
                     int capacity,
                     int attendersQuantity) {
        if (isFriday && attendersQuantity < capacity) {
            return true;
        } else return isClothesSuitable && attendersQuantity < capacity;
    }

    boolean letOut(boolean isThereDebt) {
        return !isThereDebt;
    }
}
