package org.example.homeWorks.hw3.components.interfaces;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WirelessCharging implements DeskOption {
    String wirelessModuleName = "WirelessModule";

    @Override
    public String getName() {
        return wirelessModuleName;
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
