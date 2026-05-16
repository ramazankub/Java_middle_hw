package org.example.homeWorks.hw9;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;


    public void addNewMaintenanceRecord(MaintenanceRecord maintenanceRecord) {
        maintenanceRecords.add(maintenanceRecord);
        maintenanceRecord.setCar(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }
}
