package java13_java_thread.lesson04_deadlock;

import org.junit.jupiter.api.Test;

/**
 * Deadlock
 *
 * - Race condition sangat mudah diselesaikan dengan synchronization dan lock, namun masalah lain bisa mengintai jika
 *   kita salah melakukan synchronization, yaitu Deadlock
 * - Deadlock merupakan kondisi dimana beberapa thread saling menunggu satu sama lain karena biasanya terjadi ketika
 *   thread tersebut melakukan lock dan menunggu lock lain dari thread lain dan ternyata thread tersebut juga menunggu
 *   lock lain
 * - Karena saling menunggu, akhirnya terjadi deadlock, keadaan dimana semua thread tidak berjalan karena hanya menunggu
 *   lock
 */
public class DeadlockTest {

    @Test
    void deadlock() throws InterruptedException {
        var balance1 = new Balance(1_000_000L);
        var balance2 = new Balance(1_000_000L);

        var thread1 = new Thread(() -> {
            try {
                Balance.transfer(balance1, balance2, 500_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balance2, balance1, 500_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balance1.getValue());
        System.out.println(balance2.getValue());
    }
}
