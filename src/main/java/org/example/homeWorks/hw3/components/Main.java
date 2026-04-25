package org.example.homeWorks.hw3.components;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        DeskFactory factory = new DeskFactory();

        //Desk desk = factory.createCommonDesk();

        for (int i = 0; i < 5_000_000; i++) {
            Desk desk1 = factory.createCommonDesk();
            desk1.calculateTotalPrice();
        }

        //System.out.println(desk + " - " + desk.calculateTotalPrice());

        long end = System.currentTimeMillis();

        System.out.println("spend msec: " + (end - start));

        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("Max heap: " + maxMemory / 1024 / 1024 + " MB");
        System.out.println("Used heap: " + (totalMemory - freeMemory) / 1024 / 1024 + " MB");
    }
}