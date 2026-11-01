package org.example.homeWorks.hw11;

import java.time.Instant;

public record SensorData(
        Instant timestamp,
        double value
) {
}
