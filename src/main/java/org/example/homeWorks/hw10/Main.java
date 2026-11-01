package org.example.homeWorks.hw10;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static final int DECREASE = 2_500_000;
    private static final int INCREASE = 3_200_000;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        long input = scanner.nextLong();

        AtomicLong value = new AtomicLong(input);

        Thread decreaseThread = new Thread(() -> {
            for (int i = 0; i < DECREASE; i++) {
                value.decrementAndGet();
            }
        }, "DecreaseThread");

        Thread increaseThread = new Thread(() -> {
            for (int i = 0; i < INCREASE; i++) {
                value.incrementAndGet();
            }
        }, "IncreaseThread");

        decreaseThread.start();
        decreaseThread.join();

        System.out.println("После уменьшения: " + value.get());

        increaseThread.start();
        increaseThread.join();

        System.out.println("После увеличения: " + value.get());

        long expected = Math.addExact(input, 700_000L);

        System.out.println("Ожидаемый результат: " + expected);
        System.out.println("Результат корректен: "
                + (value.get() == expected));
    }
}
