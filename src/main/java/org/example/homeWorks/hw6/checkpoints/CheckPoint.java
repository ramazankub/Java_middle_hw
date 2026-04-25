package org.example.homeWorks.hw6.checkpoints;

public abstract class CheckPoint {
    private String name;
    private final boolean isMandatory;
    private double latitude;
    private double longitude;

    protected CheckPoint(CheckPointBuilder builder) {
        this.name = builder.name;
        this.isMandatory = builder.isMandatory;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public String getName() {
        return name;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static class CheckPointBuilder {
        private String name;
        private final boolean isMandatory;
        private double latitude;
        private double longitude;

        public CheckPointBuilder(boolean isMandatory) {
            this.isMandatory = isMandatory;
        }

        public CheckPointBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CheckPointBuilder setLatitude(double latitude) {
            if(latitude < 0 || latitude > 180) {
                throw new IllegalArgumentException("широта должна быть между 0 и 180");
            }

            this.latitude = latitude;
            return this;
        }

        public CheckPointBuilder setLongitude(double longitude) {
            if(longitude < 0 || longitude > 180) {
                throw new IllegalArgumentException("долгота должна быть между 0 и 180");
            }

            this.longitude = longitude;
            return this;
        }
    }
}
