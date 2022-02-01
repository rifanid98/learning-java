package java13_java_thread.lesson21_exchanger;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger
 *
 * - Exchanger merupakan fitur synchronizer untuk melakukan pertukaran data antar thread
 * - Jika data belum tersedia, maka thread yang melakukan pertukaran akan menunggu sampai ada thread lain yang melakukan
 *   pertukaran data
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Exchanger.html
 */
public class ExchangerTest {

    @Test
    void exchanger() throws InterruptedException {
        final var exchanger = new Exchanger<String>();
        final var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                var value = exchanger.exchange("First");
                System.out.println("1. " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                var value = exchanger.exchange("Second");
                System.out.println("2. " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
