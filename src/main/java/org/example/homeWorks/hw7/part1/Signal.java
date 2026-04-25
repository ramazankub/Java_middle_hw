package org.example.homeWorks.hw7.part1;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Signal {
    RED("STOP"),
    YELLOW("WAIT"),
    GREEN("GO");

    private final String action;

    Signal(String signalName) {
        this.action = signalName;
    }
}
