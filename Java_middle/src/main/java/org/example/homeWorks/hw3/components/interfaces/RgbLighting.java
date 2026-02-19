package org.example.homeWorks.hw3.components.interfaces;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RgbLighting implements DeskOption {
    String RgbLightingName =  "RgbLighting";

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
