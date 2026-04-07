package org.example.homeWorks.hw6;

import org.example.homeWorks.hw6.checkpoints.CheckPoint;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<CheckPoint> checkPoints = new ArrayList<>();

    public void addCheckPoint(CheckPoint checkPoint) {
        checkPoints.add(checkPoint);
    }

    public List<CheckPoint> getCheckPoints() {
        return checkPoints;
    }
}
