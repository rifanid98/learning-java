package java13_java_thread.lesson26_thread_local_random;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalRandom
 *
 * - Pada materi-materi sebelumnya, kita sering menggunakan class Random untuk membuat angka random
 * - Saat menggunakan object Random secara parallel, maka di dalam class Random kita akan melakukan sharing variable,
 *   hal ini membuat class Random tidak aman dan juga lambat
 * - Oleh karena itu terdapat class ThreadLocalRandom, ThreadLocalRandom merupakan class yang seperti ThreadLocal, namun
 *   spesial untuk Random, sehingga kita bisa membuat angka random tanpa khawatir dengan race condition, karena object Random nya akan berbeda tiap thread
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ThreadLocalRandom.html
 */
public class ThreadLocalRandomTest {

    @Test
    void threadLocalRandom() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    int nextInt = ThreadLocalRandom.current().nextInt(1000);
                    System.out.println(nextInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * ThreadLocalRandom Stream
     *
     * - Fitur lainnya di ThreadLocalRandom adalah, dia memiliki fitur untuk membuat random number secara stream
     * - Hal ini mempermudah kita ketika ingin melakukan random number tanpa harus pusing membuat perulangan secara
     *   manual
     * - ada banyak method di ThreadLocalRandom seperti ints(), longs() dan doubles() yang mengembalikan data stream
     */
    @Test
    void threadLocalRandomStream() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            ThreadLocalRandom.current()
                    .ints(1000, 0, 1000)
                    .forEach(System.out::println);
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
