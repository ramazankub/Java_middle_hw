package org.example.homeWorks.hw6.cars;

public class CarFactory {
    public static RacingTruck createRacingTruck(String plate, String color, double fuelVolume, double power) {
        return new RacingTruck.RacingTruckBuilder()
                .setPlate(plate)
                .setColor(color)
                .setFuelVolume(fuelVolume)
                .setPower(power)
                .build();
    }

    public static RacingCar createCar(String plate, String color, double fuelVolume, double power) {
        return new RacingCar.RacingCarBuilder()
                .setPlate(plate)
                .setColor(color)
                .setFuelVolume(fuelVolume)
                .setPower(power)
                .build();
    }
}
