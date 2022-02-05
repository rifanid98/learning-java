package java17_lombok.lesson13_synchronized;

import org.junit.jupiter.api.Test;

/**
 * Synchronized
 *
 * - Saat belajar Java Thread, kita sudah tahu agar sebuat method aman dari race condition, kita biasanya menggunakan
 *   kata kunci synchronized, atau yang lebih baik adalah menggunakan Lock
 * - Lombok memiliki fitur untuk mempermudah kita ketika membuat Lock agar method yang kita buat aman dari race condition
 * - Kita bisa menggunakan annotation @Synchronized, dan jika kita ingin sharing lock dengan beberapa method, kita bisa
 *   gunakan value lock yang sama
 */
public class SynchronizedTest {

    @Test
    void synchronizedTest() throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    counter.increment();
                }
            }).start();
        }

        Thread.sleep(2000L);
        System.out.println(counter.getCounter());
    }
}
