package java13_java_thread.lesson05_thread_communication;

import org.junit.jupiter.api.Test;

/**
 * Thread Communication
 *
 * - Dalam multithreaded programming, kadang sudah biasa ketika sebuah thread perlu menunggu thread lain menyelesaikan
 *   tugas tertentu, baru thread tersebut melakukan tugasnya
 * - Sayangnya tidak ada cara otomatis komunikasi antar thread secara langsung
 * - Oleh karena itu, programmer harus melakukannya secara manual untuk komunikasi antar thread
 */
public class ThreadCommunicationTest {

    public String message = null;

    @Test
    void threadCommunication() throws InterruptedException {
        var thread1 = new Thread(() -> {
            while (message == null) {
            }
            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
            message = "Adnin";
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();
    }

    /**
     * Wait dan Notify
     *
     * - Menggunakan loop untuk menunggu sangat tidak direkomendasikan, alasannya buang-buang resource CPU dan juga jika
     *   terjadi interrupt, loop akan terus berjalan tanpa henti
     * - Java sudah menyediakan solusi yang lebih baik dengan menambahkan method wait dan notify di java.lang.Object
     * - Artinya kita bisa membuat object apapun menjadi lock, dan gunakan wait() untuk menunggu, dan gunakan notify()
     *   untuk memberitahu bahwa data sudah tersedia
     * - notify() akan memberi tahu thread lain yang sedang melakukan wait() bahwa proses bisa dilanjutkan
     */
    @Test
    void waitAndNotify() throws InterruptedException {
        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Adnin";
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    /**
     * Notify All
     *
     * - Kadang ada kasus dimana sebuah lock ditunggu oleh banyak thread, notify() hanya memberi sinyal kepada satu
     *   thread saja
     * - Jika kita ingin mengirim sinyal ke semua thread, kita bisa menggunakan method notifyAll()
     */
    @Test
    void waitNotifyAll() throws InterruptedException {
        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                message = "Adnin";
                lock.notifyAll();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
