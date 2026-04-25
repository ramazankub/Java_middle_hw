package org.example.homeWorks.hw3.components.interfaces;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UsbModule implements DeskOption {
    String usbModuleName = "UsbModule";

    @Override
    public String getName() {
        return usbModuleName;
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
