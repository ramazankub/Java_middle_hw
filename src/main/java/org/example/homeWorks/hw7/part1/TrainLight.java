package org.example.homeWorks.hw7.part1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainLight extends LightSwitch {
    private boolean isTrainComing;
    public TrainLight(State state) {
        super(state);
    }
}
