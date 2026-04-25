package org.example.homeWorks.hw6.cars;

public abstract class Car {
    private String plate;
    private String color;
    private double power;
    private double fuelVolume;

    protected Car(CarBuilder builder) {
        this.plate = builder.plate;
        this.color = builder.color;
        this.power = builder.power;
        this.fuelVolume = builder.fuelVolume;
    }

    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }

    public double getPower() {
        return power;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public static class CarBuilder {
        private String plate;
        private String color;
        private double power;
        private double fuelVolume;

        public CarBuilder setPlate(String plate) {
            this.plate = plate;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return  this;
        }

        public CarBuilder setPower(double power) {
            this.power = power;
            return this;
        }

        public CarBuilder setFuelVolume(double fuelVolume) {
            this.fuelVolume = fuelVolume;
            return this;
        }
    }
}
