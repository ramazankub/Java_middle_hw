package org.example.homeWorks.hw11;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SensorDataProcessorBuffered {

    private final SensorDataBufferedWriter writer;
    private final int bufferSize;
    private final List<SensorData> buffer = new ArrayList<>();

    public SensorDataProcessorBuffered(
            SensorDataBufferedWriter writer,
            int bufferSize
    ) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException(
                    "Размер буфера должен быть больше нуля"
            );
        }

        this.writer = writer;
        this.bufferSize = bufferSize;
    }

    public synchronized void process(SensorData data) {

        buffer.add(data);

        buffer.sort(
                Comparator.comparing(SensorData::timestamp)
        );

        if (buffer.size() >= bufferSize) {
            flush();
        }
    }

    public synchronized void flush() {

        if (buffer.isEmpty()) {
            return;
        }

        writer.write(List.copyOf(buffer));

        buffer.clear();
    }

    public synchronized int getBufferSize() {
        return buffer.size();
    }
}
