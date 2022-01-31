package java13_java_thread.lesson08_threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Management Thread itu Sulit
 * <p>
 * - Thread merupakan object yang sangat mahal, pembuatan object thread bisa memakan memory 512kb - 1mb
 * - Jika kita tidak mengatur pembuatan thread, bisa jadi aplikasi kita akan cepat kehabisan memory sehingga bisa
 * menyebabkan error OutOfMemory
 * - Selain itu, membuat object thread baru tidak semurah membuat object class biasa, oleh karena itu sebenarnya
 * pembuatan thread secara manual tidaklah disarankan
 * - Di versi Java moderen ini, lebih disarankan menggunakan Threadpool untuk management thread
 * <p>
 * Threadpool
 * <p>
 * - Threadpool merupakan class yang digunakan untuk management thread
 * - Dengan threadpool, kita tidak perlu membuat thread secara manual, karena semua sudah diatur oleh threadpool
 * - Selain itu threadpool bisa melakukan reusable thread yang sudah selesai bekerja
 * - Threadpool di Java direpresentasikan dalam class bernama ThreadPoolExecutor
 * <p>
 * Pengaturan ThreadPool
 * <p>
 * - Ada beberapa yang harus kita atur ketika membuat threadpool
 * - core pool, minimal thread yang akan dibuat ketika threadpool dibuat
 * - max pool, maximal thread yang akan dibuat
 * - keep alive time, berapa lama thread akan dihapus jika tidak bekerja
 * - queue, antrian untuk menampung pekerjaan yang dikirim ke threadpool
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html
 */
public class ThreadpoolTest {

    @Test
    void createThreadpool() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var time = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue);
    }

    /**
     * Eksekusi Runnable
     * <p>
     * - Untuk melakukan eksekusi Runnable, kita bisa menggunakan method execute() milik threadpool
     * - Secara otomatis data runnable akan dikirim ke queue threadpool untuk dieksekusi oleh thread yang terdapat di
     * threadpool
     */
    @Test
    void eksekusiRunnable() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var time = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue);
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Hello from Threadpool : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(6000);
    }

    /**
     * Menghentikan Threadpool
     * <p>
     * - Jika kita sudah selesai menggunakan threadpool, dan tidak akan menggunakannya lagi, ada baiknya kita hentikan
     * dan matikan ThreadPool nya
     * - Caranya kita bisa menggunakan method shutdown() untuk menghentikan threadpool, jika ada pekerjaan yang belum
     * dikerjakan, maka akan di ignore
     * - Atau gunakan shutdownNow() untuk menghentikan threadpool, namun pekerjaan yang belum dikerjakan akan dikembalikan
     * - Atau jika kita ingin menunggu sampai threadpool selesai, kita bisa gunakan awaitTermination()
     */
    @Test
    void stopThreadpool() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var time = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(1000);
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue);

        for (int i = 0; i < 1000; i++) {
            final var task = 1;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " from Threadpool " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }

//        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * Rejected Handler
     *
     * - Apa yang terjadi jika queue penuh dan thread juga semua sedang bekerja?
     * - Maka secara otomatis akan di handle oleh object RejectedExecutionHandler
     * - Secara default, implementasi rejected handler akan akan mengembalikan exception RejectedExecutionException
     *   ketika kita submit(Runnable) pada kondisi queue penuh dan thread sedang bekerja semua
     * - Jika kita ingin mengubahnya, kita bisa membuat RejectedExecutionHandler sendiri
     */
    @Test
    void rejectedHandler() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var time = TimeUnit.MINUTES;
        var rejectedHandler = new LogRejectedExecutionHandler();

        var queue = new ArrayBlockingQueue<Runnable>(10);
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue, rejectedHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = 1;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " from Threadpool " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }

//        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
