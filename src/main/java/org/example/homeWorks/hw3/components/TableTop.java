package org.example.homeWorks.hw3.components;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.homeWorks.hw3.components.abstractClasses.DeskComponent;
import org.example.homeWorks.hw3.components.enums.MaterialsEnum;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class TableTop extends DeskComponent {
    private int thickness; //см
    private int maxLoad; //кг
    private String color;
    private MaterialsEnum material;
}
