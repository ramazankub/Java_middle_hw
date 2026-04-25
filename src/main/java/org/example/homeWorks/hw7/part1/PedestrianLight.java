package org.example.homeWorks.hw7.part1;

public class PedestrianLight extends LightSwitch {


    public PedestrianLight(State state) {
        super(state);
    }

    public void letGo() {
        System.out.println("Движение пешеходам разрещено");
    }

    public void stop() {
        System.out.println("Движение пешеходам запрещено");
    }
}
