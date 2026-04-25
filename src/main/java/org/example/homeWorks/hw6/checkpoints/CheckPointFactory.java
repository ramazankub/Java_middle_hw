package org.example.homeWorks.hw6.checkpoints;

public class CheckPointFactory {
    public static OptionalCheckPoint create(String name, double latitude, double longitude) {
        return new OptionalCheckPoint.OptionalCheckPointBuilder()
                .setName(name)
                .setLatitude(latitude)
                .setLongitude(longitude)
                .build();
    }

    public static MandatoryCheckPoint create(String name, double latitude, double longitude, double elevation) {
        return new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                .setName(name)
                .setLatitude(latitude)
                .setLongitude(longitude)
                .build();
    }
}
