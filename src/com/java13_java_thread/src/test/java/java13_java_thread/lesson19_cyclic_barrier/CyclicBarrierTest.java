package java13_java_thread.lesson19_cyclic_barrier;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * Cyclic Barrier
 *
 * - CyclicBarrier merupakan fitur yang bisa kita gunakan untuk saling menunggu, sampai jumlah thread yang menunggu
 *   terpenuhi
 * - Diawal kita akan tentukan berapa jumlah thread yang menunggu, jika sudah terpenuhi, maka secara otomatis proses
 *   menunggu akan selesai
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CyclicBarrier.html
 */
public class CyclicBarrierTest {

    @Test
    void cyclicBarrier() {
        final var cyclicBarrier = new CyclicBarrier(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    cyclicBarrier.await();
                    System.out.println("Done Waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
