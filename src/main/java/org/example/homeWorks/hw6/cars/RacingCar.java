package org.example.homeWorks.hw6.cars;

public class RacingCar extends Car {
    protected RacingCar(CarBuilder builder) {
        super(builder);
    }

    public static class RacingCarBuilder extends CarBuilder {
        public RacingCar build() {
            return new RacingCar(this);
        }

        @Override
        public RacingCarBuilder setPlate(String plate) {
            super.setPlate(plate);
            return this;
        }

        @Override
        public RacingCarBuilder setColor(String color) {
            super.setColor(color);
            return this;
        }

        @Override
        public RacingCarBuilder setFuelVolume(double fuelVolume) {
            super.setFuelVolume(fuelVolume);
            return this;
        }

        @Override
        public RacingCarBuilder setPower(double power) {
            super.setPower(power);
            return this;
        }
    }
}
