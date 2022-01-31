package java13_java_thread.lesson11_completable_future;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CompletableFuture
 *
 * - Pada Java 8, terdapat sebuah class baru bernama CompletableFuture, ini merupakan implementasi Future yang bisa kita
 *   set datanya secara manual
 * - CompletableFuture sangat cocok ketika kita misal perlu membuat future secara manual, sehingga kita tidak memerlukan
 *   Callable
 * - Untuk memberi value terhadap CompletableFuture secara manual, kita bisa menggunakan method complete(value) atau
 *   completeExceptionally(error) untuk error
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletableFuture.html
 */
public class CompletableFutureTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Random random = new Random();

    public CompletableFuture<String> getValue() {
        CompletableFuture<String> future = new CompletableFuture<>();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Done");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }

    @Test
    void completableFuture() throws ExecutionException, InterruptedException {
        Future<String> future = getValue();
        System.out.println(future.get());
    }

    public void execute(CompletableFuture<String> future, String value) {
        try {
            Thread.sleep(1000 + random.nextInt(5000));
            future.complete(value);
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
            e.printStackTrace();
        }
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();
        execute(future, "Thread 1");
        execute(future, "Thread 2");
        return future;
    }

    @Test
    void completableFuture2() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get());
    }

    /**
     * CompletionStage
     *
     * - CompletableFuture merupakan turunan dari interface CompletionStage
     * - CompletionStage merupakan fitur dimana kita bisa menambahkan asynchronous computation, tanpa harus menunggu
     *   dulu data dari Future nya ada
     * - CompletionStage sangat mirip dengan operation di Java Stream, hanya saja tidak sekomplit di Java Stream
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CompletionStage.html
     */
    @Test
    void completionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String[]> future = getValue()
                .thenApply(String::toUpperCase)
                .thenApply(value -> value.split(""));

        var result = future.get();
        for (var string: result) {
            System.out.println(string);
        }
    }
}
