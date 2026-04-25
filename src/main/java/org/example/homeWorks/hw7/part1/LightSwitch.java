package org.example.homeWorks.hw7.part1;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LightSwitch implements SwitchAble {
    @Setter(AccessLevel.PACKAGE)
    private State state;

    public LightSwitch(State state) {
        this.state = state;
    }

    public void changeState() {
        state.changeState(this);
    }

    public void printSignal() {
        System.out.println(
                getState().getSignal().name()
                        + " - "
                        + getState().getSignal().getAction()
        );
    }

    @Override
    public void switchLightOn() {
        changeState();
    }

    class OnRed implements State {

        @Override
        public void changeState(LightSwitch context) {
            context.setState(new OnYellow());
        }

        @Override
        public Signal getSignal() {
            return Signal.RED;
        }
    }

    class OnYellow implements State {

        @Override
        public void changeState(LightSwitch context) {
            context.setState(new OnGreen());
        }

        @Override
        public Signal getSignal() {
            return Signal.YELLOW;
        }
    }

    class OnGreen implements State {

        @Override
        public void changeState(LightSwitch context) {
            context.setState(new OnRed());
        }

        @Override
        public Signal getSignal() {
            return Signal.GREEN;
        }
    }
}
