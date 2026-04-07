package org.example.homeWorks.hw6.checkpoints;

public class MandatoryCheckPoint extends CheckPoint implements Fineable {
    protected MandatoryCheckPoint(CheckPointBuilder builder) {
        super(builder);
    }

    @Override
    public final boolean isMandatory() {
        return true;
    }

    @Override
    public String getFine() {
        return "Вы не прошли чекпоинт. Вернитесь к чекпоинту";
    }

    public static class MandatoryCheckPointBuilder extends CheckPointBuilder {

        public MandatoryCheckPointBuilder() {
            super(true);
        }

        @Override
        public MandatoryCheckPointBuilder setName(String name) {
            super.setName(name);
            return this;
        }

        @Override
        public MandatoryCheckPointBuilder setLatitude(double latitude) {
            super.setLatitude(latitude);
            return this;
        }

        @Override
        public MandatoryCheckPointBuilder setLongitude(double longitude) {
            super.setLongitude(longitude);
            return this;
        }

        public MandatoryCheckPoint build() {
            return new MandatoryCheckPoint(this);
        }
    }
}
