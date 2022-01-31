package java13_java_thread.lesson13_scheduled_execution_service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduled Executor Service
 *
 * - ExecutorService memiliki sub child interface bernama ScheduledExecutorService
 * - Fitur tambahan di ScheduledExecutorService adalah, kita bisa melakukan asynchronous task yang terjadwal
 * - Hal ini sangat cocok untuk kasus delayed job (pekerjaan yang butuh ditangguhkan pengerjaannya) dan periodic job
 * - ScheduledExecutorService merupakan fitur yang bisa menggantikan low level penggunaan Timer
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ScheduledExecutorService.html
 *
 * ScheduledFuture
 *
 * - Hampir semua method di ScheduledExecutorService mengembalikan data ScheduledFuture
 * - ScheduledFuture sebenarnya mirip dengan Future, yang membedakan, dia adalah turunan dari interface Delayed, yang
 *   memiliki method untuk mendapatkan informasi waktu delay
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ScheduledFuture.html
 *
 * Membuat ScheduledExecutorService
 *
 * - Untuk membuat ScheduledExecutorService kita bisa menggunakan implementasi class ScheduledThreadPoolExecutor
 * - Atau jika ingin mudah, kita bisa gunakan class Executors, terdapat method newSingleThreadScheduledExecutor() dan
 *   newScheduledThreadPool(poolSize) untuk membuat ScheduledExecutorService
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ScheduledThreadPoolExecutor.html
 */
public class ScheduledExecutionServiceTest {

    @Test
    void delayedJob() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        var future = scheduledExecutorService.schedule(() -> {
            System.out.println("Hello Delayed Job");
        }, 5, TimeUnit.SECONDS);
        System.out.println(future.getDelay(TimeUnit.SECONDS));
        scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void periodicJob() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        var future = scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Hello Delayed Job");
        }, 2, 2, TimeUnit.SECONDS);
        System.out.println(future.getDelay(TimeUnit.SECONDS));
        scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
