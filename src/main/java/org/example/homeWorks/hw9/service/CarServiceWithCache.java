package org.example.homeWorks.hw9.service;

import jakarta.persistence.EntityManager;
import org.example.homeWorks.hw9.Car;
import org.example.homeWorks.hw9.cache.MyCache;

public class CarServiceWithCache {

    private final EntityManager em;

    private final MyCache<Integer, Car> cache =
            new MyCache<>();

    public CarServiceWithCache(EntityManager em) {
        this.em = em;
    }

    public Car getCarById(int id) {

        // CACHE HIT
        if (cache.containsKey(id)) {
            return cache.get(id);
        }

        // DB HIT
        Car car = em.find(Car.class, id);

        if (car != null) {
            cache.put(id, car);
        }

        return car;
    }

    public int getCacheSize() {
        return cache.size();
    }
}