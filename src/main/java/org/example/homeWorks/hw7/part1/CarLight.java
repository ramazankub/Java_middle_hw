package org.example.homeWorks.hw7.part1;

public class CarLight extends LightSwitch {
    public CarLight(State state) {
        super(state);
    }

    public void letGo() {
        System.out.println("Движение машинам разрешено");
    }

    public void stop() {
        System.out.println("Движение машинам запрещено");
    }
}
