package org.example.homeWorks.hw3.components;

import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.homeWorks.hw3.components.abstractClasses.DeskComponent;

@SuperBuilder
@ToString(callSuper = true)
public class Engine extends DeskComponent {
    private int power;
    private int liftingSpeed;
    private int voiceLevel;
    private int sectionsQuantity;
}
