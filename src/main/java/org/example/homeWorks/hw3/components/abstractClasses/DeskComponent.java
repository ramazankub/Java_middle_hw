package org.example.homeWorks.hw3.components.abstractClasses;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@Getter
public abstract class DeskComponent {
    private final String componentName;
    private final int price;

    protected DeskComponent(String componentName, int price) {
        this.componentName = componentName;
        this.price = price;
    }
}
