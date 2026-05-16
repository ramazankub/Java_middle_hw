package org.example.homeWorks.hw9;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class MaintenanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int price;
    private LocalDate localDate;
    @ManyToOne
    private Car car;


    public MaintenanceRecord(int id, String description, int price, LocalDate localDate, Car car) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.localDate = localDate;
        this.car = car;
    }

    @Override
    public String toString() {
        return "MaintenanceRecord{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                '}';
    }
}
