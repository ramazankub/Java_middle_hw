package org.example.homeWorks.hw3.components;

import lombok.ToString;
import org.example.homeWorks.hw3.components.enums.ConstructionEnum;
import org.example.homeWorks.hw3.components.enums.MaterialsEnum;
import org.example.homeWorks.hw3.components.interfaces.BluetoothModule;

import java.util.List;

@ToString
public class DeskFactory {

   public Desk createCommonDesk() {
        var frame = Frame.builder()
               .thickness(10)
               .maxLoad(20)
               .color("Brown")
               .construction(ConstructionEnum.FIXED)
               .material(MaterialsEnum.WOOD)
               .componentName("Frame")
               .price(1000).build();

        var tableTop = TableTop.builder()
                .thickness(15)
                .maxLoad(30).color("Brown")
                .material(MaterialsEnum.WOOD)
                .componentName("Tabletop")
                .price(2000).build();

        var bluetoothmodule = BluetoothModule.builder()
                .build();

       return Desk.builder()
               .frame(frame)
               .tableTop(tableTop)
               .addedPrice(2200)
               .options(List.of(bluetoothmodule))
               .build();
   }
}
