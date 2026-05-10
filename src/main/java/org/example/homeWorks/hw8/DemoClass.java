package org.example.homeWorks.hw8;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class DemoClass {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("autoservice-unit");

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            // Создание владельцев
            Owner razor = new Owner(0, "Razor");
            Owner protagonist = new Owner(0, "Protagonist");

            em.persist(razor);
            em.persist(protagonist);

            // Создание машины
            Car bmw = new Car();
            bmw.setName("BMW M3 GTR");
            bmw.setOwner(razor);

            em.persist(bmw);

            // Первое ТО
            MaintenanceRecord firstMaintenance = new MaintenanceRecord(
                    0,
                    "Transmission replacement",
                    5000,
                    LocalDate.now(),
                    bmw
            );

            em.persist(firstMaintenance);

            bmw.addNewMaintenanceRecord(firstMaintenance);

            // Смена владельца
            bmw.setOwner(protagonist);

            // Второе ТО
            MaintenanceRecord secondMaintenance = new MaintenanceRecord(
                    0,
                    "Engine restoration",
                    12000,
                    LocalDate.now(),
                    bmw
            );

            em.persist(secondMaintenance);

            bmw.getMaintenanceRecords().add(secondMaintenance);

            em.getTransaction().commit();

            // Вывод истории ТО
            System.out.println("Maintenance history for car: " + bmw );

            for (MaintenanceRecord record : bmw.getMaintenanceRecords()) {
                System.out.println(record);
            }

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }
    }
}