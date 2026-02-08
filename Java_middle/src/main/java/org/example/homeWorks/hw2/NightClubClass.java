package org.example.homeWorks.hw2;

import lombok.Getter;

public class NightClubClass {
    final BouncerClass bouncer;

    @Getter
    int attendersQuantity = 0;
    int capacity;

    public NightClubClass(BouncerClass bouncer, int capacity) {
        this.bouncer = bouncer;
        this.capacity = capacity;
    }

    public boolean enter(boolean isFriday, boolean isClothesSuitable) {
        if(bouncer.canEnter(isFriday, isClothesSuitable, capacity, attendersQuantity)) {
            attendersQuantity++;
            return true;
        }
        return false;
    }

    public boolean exit(boolean isThereDebt) {
        if (attendersQuantity > 0 && bouncer.letOut(isThereDebt)) {
            attendersQuantity--;
            return true;
        }
        return false;
    }
}
