package org.example.homeWorks.hw3.components;

import lombok.*;
import org.example.homeWorks.hw3.components.interfaces.DeskOption;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@EqualsAndHashCode
public class Desk {
    private Engine engine;
    private Frame frame;
    private TableTop tableTop;
    private int addedPrice;

    @Singular
    List<DeskOption> options = new ArrayList<>();

    public int calculateTotalPrice() {
        int total = 0;
        total += addedPrice;

        if (tableTop != null) {
            total += tableTop.getPrice();
        }

        if (frame != null) {
            total += frame.getPrice();
        }

        total += options.stream().mapToInt(DeskOption::getPrice).sum();
        return total;
    }
}
