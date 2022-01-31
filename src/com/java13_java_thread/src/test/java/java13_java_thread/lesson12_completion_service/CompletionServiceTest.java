package java13_java_thread.lesson12_completion_service;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CompletionService
 *
 * - CompletionService merupakan sebuah interface yang digunakan untuk memisahkan antara bagian yang mengeksekusi
 *   asynchronous task dan yang menerima hasil dari task yang sudah selesai
 * - Kadang ada kebutuhan misal kita butuh menjalankan sesuatu secara parallel, lalu ada satu thread yang melakukan
 *   eksekusi task dan satu thread menunggu hasil nya
 * - Kita bisa menggunakan CompletionService untuk melakukan itu
 * - Implementasi interface CompletionService adalah class ExecutorCompletionService
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletionService.html
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ExecutorCompletionService.html
 */
public class CompletionServiceTest {

    private Random random = new Random();

    @Test
    void completionService() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        var service = new ExecutorCompletionService<String>(executor);

        // submit task
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var task = i;
                service.submit(() -> {
                    Thread.sleep(random.nextInt(2000));
                    return "Task " + task;
                });
            }
        });

        // get result
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    Future<String> future = service.poll(5, TimeUnit.SECONDS);
                    if (future == null) {
                        break;
                    } else  {
                        System.out.println(future.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    break;
                }
            }
        });

        // executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
