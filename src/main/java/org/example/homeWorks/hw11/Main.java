package org.example.homeWorks.hw11;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        SensorDataBufferedWriter writer = data ->
                System.out.println("Запись в хранилище: " + data);

        SensorDataProcessorBuffered processor =
                new SensorDataProcessorBuffered(writer, 3);

        processor.process(new SensorData(
                Instant.parse("2026-11-01T10:00:03Z"), 25.5));

        processor.process(new SensorData(
                Instant.parse("2026-11-01T10:00:01Z"), 23.1));

        processor.process(new SensorData(
                Instant.parse("2026-11-01T10:00:02Z"), 24.8));

        processor.process(new SensorData(
                Instant.parse("2026-11-01T10:00:04Z"), 26.0));

        // Записываем оставшиеся измерения
        processor.flush();
    }
}