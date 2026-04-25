package org.example.homeWorks.hw7.part1;

public class TrafficLightFactory {

    public static LightSwitch create(TrafficLightType type) {

        return switch(type) {

            case CAR ->
                    new CarLight(
                            new LightSwitch(null).new OnRed()
                    );

            case TRAIN ->
                    new TrainLight(
                            new LightSwitch(null).new OnRed()
                    );

            case PEDESTRIAN ->
                    new PedestrianLight(
                            new LightSwitch(null).new OnRed()
                    );
        };
    }
}
