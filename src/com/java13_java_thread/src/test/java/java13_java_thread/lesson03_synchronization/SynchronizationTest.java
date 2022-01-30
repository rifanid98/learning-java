package java13_java_thread.lesson03_synchronization;

import java13_java_thread.lesson02_race_condition.Counter;
import org.junit.jupiter.api.Test;

/**
 * Synchronization
 *
 * - Masalah race condition sebelumnya yang terjadi di Java bisa diselesaikan dengan Synchronization
 * - Synchronization merupakan fitur dimana kita memaksa kode program hanya boleh diakses dan dieksekusi oleh satu thread
 *   saja
 * - Hal ini menyebabkan thread yang lain yang akan mengakses kode program tersebut harus menunggu thread yang lebih
 *   dahulu mengakses, sehingga proses Synchronization akan lebih lambat, namun proses Synchronization lebih aman karena
 *   tidak akan terjadi race condition
 */
public class SynchronizationTest {

    /**
     * Synchronized Method
     *
     * - Di Java, terdapat dua jenis synchronization, yaitu synchronized method dan synchronized statement
     * - Synchronized method method merupakan synchronization paling mudah, karena kita hanya perlu menambah kata kunci
     *   synchronized pada method yang ingin kita set sebagai synchronization
     * - Dengan begitu, secara otomatis method tersebut hanya bisa diakses oleh satu thread pada satu waktu
     *
     * Intrinsic Lock
     *
     * - Synchronization di Java sebenarnya bekerja menggunakan lock
     * - Ketika kita melakukan synchronized method, secara otomatis Java akan membuat intrinsic lock atau monitor lock
     * - Ketika synchronized method dipanggil oleh thread, thread akan melakukan mencoba mendapatkan intrinsic lock,
     *   setelah method selesai (sukses ataupun error), maka thread akan mengembalikan intrinsic lock
     * - Semua itu terjadi sejari secara otomatis di synchronized method
     */
    @Test
    void synchronizedMethod() throws InterruptedException {
        SynchronizeCounter synchronizeCounter = new SynchronizeCounter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronizeCounter.increment();
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

        System.out.println(synchronizeCounter.getValue());
    }

    /**
     * Synchronized Statement
     *
     * - Saat kita menggunakan synchronized method, secara otomatis seluruh method akan ter synchronization
     * - Kadang, misal kita hanya ingin melakukan synchronized pada bagian kode tertentu saja
     * - Untuk melakukan hal tersebut, kita bisa menggunakan synchronized statement
     * - Namun ketika kita menggunakan synchronized statement, kita harus menentukan object intrinsic lock sendiri
     */
    @Test
    void synchronizedStatement() throws InterruptedException {
        SynchronizeStatementCounter synchronizeStatementCounter = new SynchronizeStatementCounter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronizeStatementCounter.increment();
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

        System.out.println(synchronizeStatementCounter.getValue());
    }
}
