package org.example.homeWorks.hw3.components.interfaces;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BluetoothModule implements DeskOption{

    @Override
    public String getName() {
        return "Bluetooth - разъем";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
