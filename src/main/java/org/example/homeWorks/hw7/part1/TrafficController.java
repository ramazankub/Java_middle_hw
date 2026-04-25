package org.example.homeWorks.hw7.part1;

public class TrafficController {
    private TrainLight trainLight;
    private PedestrianLight pedestrianLight;
    private CarLight carLight;

    public TrafficController(TrainLight trainLight, PedestrianLight pedestrianLight, CarLight carLight) {
        this.trainLight = trainLight;
        this.pedestrianLight = pedestrianLight;
        this.carLight = carLight;
    }

    public boolean carTraffic() {
        if (trainLight.isTrainComing()
                || pedestrianLight.getState().getSignal() == Signal.GREEN) {

            carLight.stop();
            carLight.switchLightOn();
            return false;
        }

        carLight.letGo();
        carLight.switchLightOn();
        return true;
    }

    public boolean pedestrianTraffic() {
        if (carLight.getState().getSignal() == Signal.GREEN) {
            pedestrianLight.stop();
            pedestrianLight.switchLightOn();
            return false;
        }

        carLight.stop();
        carLight.switchLightOn();

        pedestrianLight.letGo();
        pedestrianLight.switchLightOn();

        return true;
    }
}
