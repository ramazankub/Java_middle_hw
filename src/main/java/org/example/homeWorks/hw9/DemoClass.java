package org.example.homeWorks.hw9;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.homeWorks.hw9.service.CarServiceWithCache;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class DemoClass {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("autoservice-unit");

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            Owner razor = new Owner(0, "Razor");
            Owner protagonist = new Owner(0, "Protagonist");

            em.persist(razor);
            em.persist(protagonist);

            List<String> carNames = List.of(
                    "BMW M3 GTR",
                    "Toyota Supra",
                    "Mazda RX-7",
                    "Mitsubishi Eclipse",
                    "Porsche Cayman"
            );

            List<String> services = List.of(
                    "Transmission replacement",
                    "Turbo installation",
                    "Nitrous refill",
                    "ECU remap",
                    "Body kit installation",
                    "Suspension tuning",
                    "Engine rebuild",
                    "Brake upgrade",
                    "Vinyl wrapping",
                    "Exhaust tuning"
            );

            Random random = new Random();

            int firstCarId = 0;

            for (String carName : carNames) {

                Car car = new Car();

                car.setName(carName);

                if (carName.equals("BMW M3 GTR")) {
                    car.setOwner(razor);
                } else {
                    car.setOwner(protagonist);
                }

                em.persist(car);

                if (firstCarId == 0) {
                    firstCarId = car.getId();
                }

                if (carName.equals("BMW M3 GTR")) {
                    car.setOwner(protagonist);
                }

                int maintenanceCount =
                        random.nextInt(3) + 2;

                for (int i = 0; i < maintenanceCount; i++) {

                    MaintenanceRecord record =
                            new MaintenanceRecord(
                                    0,
                                    services.get(
                                            random.nextInt(services.size())
                                    ),
                                    random.nextInt(15000) + 1000,
                                    LocalDate.now(),
                                    car
                            );

                    em.persist(record);

                    car.addNewMaintenanceRecord(record);
                }

                System.out.println("\n=========================");
                System.out.println(car);
                System.out.println("Maintenance history:");

                for (MaintenanceRecord record :
                        car.getMaintenanceRecords()) {

                    System.out.println(record);
                }
            }

            em.getTransaction().commit();

            // =========================
            // CACHE TEST
            // =========================

            CarServiceWithCache cacheService =
                    new CarServiceWithCache(em);

            long dbStart = System.nanoTime();

            for (int i = 0; i < 10000; i++) {
                em.find(Car.class, firstCarId);
            }

            long dbEnd = System.nanoTime();

            long cacheStart = System.nanoTime();

            for (int i = 0; i < 10000; i++) {
                cacheService.getCarById(firstCarId);
            }

            long cacheEnd = System.nanoTime();

            System.out.println("\n=========================");
            System.out.println("PERFORMANCE TEST");
            System.out.println("=========================");

            System.out.println(
                    "DB time: "
                            + (dbEnd - dbStart) / 1_000_000
                            + " ms"
            );

            System.out.println(
                    "Cache time: "
                            + (cacheEnd - cacheStart) / 1_000_000
                            + " ms"
            );

            System.out.println(
                    "Cache size: "
                            + cacheService.getCacheSize()
            );

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            em.close();
            emf.close();
        }
    }
}