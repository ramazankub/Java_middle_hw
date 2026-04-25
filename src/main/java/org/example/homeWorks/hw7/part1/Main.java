package org.example.homeWorks.hw7.part1;

import static org.example.homeWorks.hw7.part1.TrafficLightType.*;

public class Main {

    public static void main(String[] args) {

        TrainLight train =
                (TrainLight) TrafficLightFactory.create(TRAIN);

        CarLight car =
                (CarLight) TrafficLightFactory.create(CAR);

        PedestrianLight pedestrian =
                (PedestrianLight) TrafficLightFactory.create(PEDESTRIAN);


        TrafficController controller =
                new TrafficController(
                        train,
                        pedestrian,
                        car
                );


        System.out.println("=== Initial signals ===");

        System.out.print("Cars: ");
        car.printSignal();

        System.out.print("Pedestrians: ");
        pedestrian.printSignal();



        System.out.println("\n=== Cars move ===");

        controller.carTraffic();

        System.out.print("Cars: ");
        car.printSignal();



        System.out.println("\n=== Pedestrian phase ===");

        controller.pedestrianTraffic();

        System.out.print("Cars: ");
        car.printSignal();

        System.out.print("Pedestrians: ");
        pedestrian.printSignal();



        System.out.println("\n=== Railway crossing ===");

        train.setTrainComing(true);

        controller.carTraffic();

        System.out.print("Cars: ");
        car.printSignal();
    }
}