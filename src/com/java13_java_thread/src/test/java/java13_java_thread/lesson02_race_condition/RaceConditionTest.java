package java13_java_thread.lesson02_race_condition;

import org.junit.jupiter.api.Test;

/**
 * Race Condition
 *
 * - Salah satu problem yang sering sekali terjadi dalam aplikasi concurrent dan parallel adalah race condition
 * - Race condition merupakan keadaan ketika sebuah data diubah secara berbarengan oleh beberapa thread yang menyebabkan
 *   hasil akhir yang tidak sesuai dengan yang kita inginkan
 */
public class RaceConditionTest {

    @Test
    void raceCondition() throws InterruptedException {
        var counter = new Counter();
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
