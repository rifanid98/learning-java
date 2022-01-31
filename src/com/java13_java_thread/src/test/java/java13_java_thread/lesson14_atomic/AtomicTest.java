package java13_java_thread.lesson14_atomic;

import org.junit.jupiter.api.Test;

/**
 * Atomic Package
 *
 * - Java menawarkan sebuah package atomic yang berisikan class-class yang mendukung lock-free dan thread-safe
 *   programming pada single variable
 * - Setiap object Atomic class akan mengelola data yang diakses dan di update menggunakan method yang telah disediakan
 * - Atomic class melakukan implementasi Compare-and-Swap untuk mendukung synchronization
 * - Dengan menggunakan Atomic, kita tidak perlu lagi menggunakan synchronized secara manual
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/atomic/package-summary.html
 * - https://en.wikipedia.org/wiki/Compare-and-swap
 */
public class AtomicTest {

    @Test
    void atomic() throws InterruptedException {
        var counter = new CounterAtomic();
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
}
