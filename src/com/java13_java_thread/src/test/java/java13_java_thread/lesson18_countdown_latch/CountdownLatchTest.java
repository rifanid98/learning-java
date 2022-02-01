package java13_java_thread.lesson18_countdown_latch;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch
 *
 * - CountDownLatch merupakan synchronizer yang digunakan untuk menunggu beberapa proses selesai, cara kerjanya mirip
 *   dengan Semaphore, yang membedakan adalah pada CountDownLatch, counter diawal sudah ditentukan
 * - Setelah proses selesai, kita akan menurunkan counter
 * - Jika counter sudah bernilai 0, maka yang melakukan wait bisa lanjut berjalan
 * - CountDownLatch cocok jika kita misal ingin menunggu beberapa proses yang berjalan secara asynchronous sampai semua
 *   proses selesai
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/CountDownLatch.html
 */
public class CountdownLatchTest {

    @Test
    void countdownLatch() throws InterruptedException {
        final var countDownLatch = new CountDownLatch(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2000);
                    System.out.println("Finish Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("Finish All Tasks");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
