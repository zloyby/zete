package by.zloy.poc.concurrency;

import java.util.concurrent.Executors;

public class VirtualSimple {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100_000; i++) {
                executor.submit(() -> {
                    // Симулируем сетевой запрос
                    Thread.sleep(1000);
                    return "OK";
                });
            }
        }
    }
}
