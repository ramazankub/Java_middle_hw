package org.example.homeWorks.hw6;

import org.example.homeWorks.hw6.cars.Car;
import org.example.homeWorks.hw6.cars.RacingCar;
import org.example.homeWorks.hw6.cars.RacingTruck;
import org.example.homeWorks.hw6.checkpoints.MandatoryCheckPoint;
import org.example.homeWorks.hw6.checkpoints.OptionalCheckPoint;

import java.util.ArrayList;
import java.util.List;

public class TrophyRaid {
    private Track track;
    private List<Car> cars;

    public TrophyRaid(Track track, List<Car> cars) {
        this.track = track;
        this.cars = cars;
    }

    public static void main(String[] args) {
        Track track = new Track();
        List<Car> cars = new ArrayList<>();


        track.addCheckPoint(new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                .setName("CP1")
                .setLatitude(40.0)
                .setLongitude(70.0)
                .build());

        track.addCheckPoint(new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                .setName("CP2")
                .setLatitude(50.0)
                .setLongitude(60.0)
                .build());

        track.addCheckPoint(new OptionalCheckPoint.OptionalCheckPointBuilder()
                .setName("CP3")
                .setLatitude(70.0)
                .setLongitude(90.0)
                .build());

        track.addCheckPoint(new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                .setName("CP4")
                .setLatitude(100.0)
                .setLongitude(170.0)
                .build());

        cars.add(new RacingTruck.RacingTruckBuilder()
                .setPlate("A123")
                .setFuelVolume(100)
                .setColor("black")
                .setPower(1000)
                .build());

        cars.add(new RacingCar.RacingCarBuilder()
                .setPlate("A233")
                .setFuelVolume(40)
                .setColor("red")
                .setPower(355)
                .build());

        TrophyRaid raid = new TrophyRaid(track, cars);
        raid.startRace();
    }

    public void startRace() {
        System.out.println("Гонка началась!");

        System.out.println("Машины:");
        cars.forEach(car ->
                System.out.println(car.getPlate() + " | " + car.getColor())
        );

        System.out.println("\nЧекпоинты:");
        track.getCheckPoints().forEach(cp ->
                System.out.println(cp.getName() + " | mandatory: " + cp.isMandatory())
        );
    }
}
