package org.example.homeWorks.hw6.checkpoints;

public class OptionalCheckPoint extends CheckPoint implements Fineable {
    protected OptionalCheckPoint(CheckPointBuilder builder) {
        super(builder);
    }

    @Override
    public String getFine() {
        return "Вы не прошли чекпоинт. Ваш штраф 10 секунд.";
    }

    @Override
    public final boolean isMandatory() {
        return false;
    }

    public static class OptionalCheckPointBuilder extends CheckPointBuilder {
        public OptionalCheckPointBuilder() {
            super(false);
        }

        public OptionalCheckPoint build() {
            return new OptionalCheckPoint(this);
        }

        @Override
        public OptionalCheckPointBuilder setName(String name) {
            super.setName(name);
            return this;
        }

        @Override
        public OptionalCheckPointBuilder setLatitude(double latitude) {
            super.setLatitude(latitude);
            return this;
        }

        @Override
        public OptionalCheckPointBuilder setLongitude(double longitude) {
            super.setLongitude(longitude);
            return this;
        }
    }
}
