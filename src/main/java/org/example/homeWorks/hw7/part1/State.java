package org.example.homeWorks.hw7.part1;

public interface State {
    void changeState(LightSwitch context);
    Signal getSignal();
}
