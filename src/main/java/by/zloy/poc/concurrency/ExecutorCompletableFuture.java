package by.zloy.poc.concurrency;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class ExecutorCompletableFuture {

    public static void main(String[] args) {
        try (ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(2)) {
            // Запускаем 2 потока
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->
                    doLongJob(1, "Hello"), executor
            );
            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->
                    doLongJob(4, "world"), executor
            );

            // Объединяем результаты, когда оба потока завершатся
            CompletableFuture<String> combinedFuture =
                    future1.thenCombine(future2, (res1, res2) -> res1 + " " + res2 + ".");
            System.out.println(combinedFuture.join());
        }
    }

    private static String doLongJob(int time, String word) {
        try {
            Thread.sleep(Duration.ofSeconds(time).toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
        return word;
    }
}
