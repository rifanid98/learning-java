package java13_java_thread.lesson15_lock;

import java13_java_thread.lesson14_atomic.CounterAtomic;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Locks Package
 *
 * - Java menyediakan high level concurrency package untuk melakukan locking atau waiting for conditions
 * - Ini adalah alternatif dari low level synchronized dan manual wait dan notify
 * - Untuk saat ini, sangat disarankan menggunakan package locks dibandingkan menggunakan low level synchronization
 *   sebelumnya yang sudah kita bahas
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/package-summary.html
 *
 * Lock Interface
 *
 * - Lock interface merupakan alternatif implementasi dari synchronized method dan synchronized statement
 * - Untuk melakukan lock, kita bisa gunakan method lock() dan setelah selesai, kita bisa menggunakan method unlock()
 *   untuk melepaskan lock
 * - Implementasi dari interface Lock adalah class ReentrantLock
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/Lock.html
 */
public class LockTest {

    private String message = null;

    @Test
    void lock() throws InterruptedException {

        var counter = new CounterLock();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }

    /**
     * ReadWriteLock
     *
     * - Kadang ada kondisi dimana kita ingin membedakan lock antara operasi update dan operasi get
     * - Untuk kasus seperti ini, kita bisa membuat dua buah variable Lock
     * - Namun, di Java disediakan cara yang lebih mudah, yaitu menggunakan interface ReadWriteLock
     * - ReadWriteLock merupakan lock yang mendukung dua jenis operasi, read dan write
     * - Implementasi dari interface ReadWriteLock adalah class ReentrantReadWriteLock
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/ReadWriteLock.html
     */
    @Test
    void counterReadWriteLock() throws InterruptedException {
        var counter = new CounterReadWriteLock();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }

    /**
     * Condition Interface
     *
     * - Condition merupakan alternatif lain dari monitor method (wait, notify dan notifyAll)
     * - Pada Java modern saat ini, sangat disarankan menggunakan Condition dibanding monitor method
     * - Condition memiliki method wait() untuk menunggu, signal() untuk mentrigger satu thread, dan signalAll() untuk
     *   mentrigger semua thread yang menunggu
     * - Cara pembuatan Condition, kita bisa menggunakan method newCondition() milik Lock
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/locks/Condition.html
     */
    @Test
    void conditionInterface() throws InterruptedException {
        var lock = new ReentrantLock();
        var condition = lock.newCondition();

        var thread1 = new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

//        var thread3 = new Thread(() -> {
//            try {
//                lock.lock();
//                message = "Adnin Rifandi Sutanto";
//                condition.signal();
//            } finally {
//                lock.unlock();
//            }
//        });

//        var thread3 = new Thread(() -> {
//            try {
//                lock.lock();
//                message = "Adnin Rifandi Sutanto";
//                condition.signalAll();
//            } finally {
//                lock.unlock();
//            }
//        });

        thread1.start();
        thread2.start();
//        thread3.start();

        thread1.join();
        thread2.join();
//        thread3.join();
    }
}
