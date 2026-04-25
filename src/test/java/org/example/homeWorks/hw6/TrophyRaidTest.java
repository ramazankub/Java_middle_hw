package org.example.homeWorks.hw6;

import org.example.homeWorks.hw6.checkpoints.MandatoryCheckPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrophyRaidTest {
    @Test
    void shouldThrowExceptionForInvalidLatitude() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                    .setName("CP")
                    .setLatitude(200)
                    .setLongitude(20)
                    .build();
        });
    }

    @Test
    void shouldAddCheckpointToTrack() {
        Track track = new Track();

        track.addCheckPoint(new MandatoryCheckPoint.MandatoryCheckPointBuilder()
                .setName("CP1")
                .setLatitude(10)
                .setLongitude(20)
                .build());

        assertEquals(1, track.getCheckPoints().size());
    }
}
