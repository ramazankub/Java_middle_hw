package org.example.homeWorks.hw6.cars;

public class RacingTruck extends Car {

    protected RacingTruck(CarBuilder builder) {
        super(builder);
    }

    public static class  RacingTruckBuilder extends CarBuilder {
        public RacingTruck build() {
            return new RacingTruck(this);
        }

        @Override
        public RacingTruckBuilder setPlate(String plate) {
            super.setPlate(plate);
            return this;
        }

        @Override
        public RacingTruckBuilder setColor(String color) {
            super.setColor(color);
            return this;
        }

        @Override
        public RacingTruckBuilder setFuelVolume(double fuelVolume) {
            super.setFuelVolume(fuelVolume);
            return this;
        }

        @Override
        public RacingTruckBuilder setPower(double power) {
            super.setPower(power);
            return this;
        }
    }
}
