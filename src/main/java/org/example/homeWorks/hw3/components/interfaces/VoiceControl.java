package org.example.homeWorks.hw3.components.interfaces;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class VoiceControl implements DeskOption {
    String voiceLevelSwitcher = "voiceLevelSwitcher";

    @Override
    public String getName() {
        return voiceLevelSwitcher;
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
