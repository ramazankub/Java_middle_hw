package org.example.homeWorks.hw3.components;

import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.homeWorks.hw3.components.abstractClasses.DeskComponent;
import org.example.homeWorks.hw3.components.enums.ConstructionEnum;
import org.example.homeWorks.hw3.components.enums.MaterialsEnum;

@SuperBuilder
@ToString(callSuper = true)
public class Frame extends DeskComponent {
    private int thickness;
    private int maxLoad;
    private String color;
    private ConstructionEnum construction;
    private MaterialsEnum material;
}
