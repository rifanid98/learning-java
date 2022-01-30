package java13_java_thread.lesson01_thread;

import org.junit.jupiter.api.Test;

/**
 * Thread
 *
 * - Di Java, implementasi Concurrency dan Parallel dapat menggunakan Thread
 * - Thread direpresentasikan oleh class bernama Thread di package java.lang
 *
 *
 */
public class ThreadTest {

    /**
     * Thread Utama
     *
     * - Secara default, saat sebuah aplikasi Java berjalan, minimal akan ada satu thread yang berjalan
     * - Dalam aplikasi Java biasa, biasanya kode program kita akan berjalan di dalam thread yang bernama main
     * - Bahkan di Unit Test pun, memiliki thread sendiri
     */
    @Test
    void mainThread() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }

    /**
     * Membuat Thread
     *
     * - Thread merupakan proses ringan, membuat Thread bukan berarti kita melakukan pekerjaan
     * - Untuk membuat pekerjaan, kita perlu membuat object dari interface Runnable, selanjutnya object Runnable tersebut
     *   bisa kita berikan ke Thread untuk dijalankan
     * - Saat Thread berjalan, dia akan berjalan secara asynchronous, artinya dia akan berjalan sendiri, dan kode program
     *   kita akan berlanjut ke kode program selanjutnya
     * - Untuk menjalankan Thread, kita bisa memanggil function start() milik Thread
     */
    @Test
    void createThread() {
        Runnable runnable = () -> System.out.println("Hello from thread " + Thread.currentThread().getName());

        var thread = new Thread(runnable);
        thread.start();
    }

    /**
     * Thread Sleep
     *
     * - Pada saat proses development, kada kita butuh melakukan simulasi proses yang berjalan dalam waktu tertentu
     * - Untuk melakukan hal ini, kita bisa memanfaatkan fitur Thread Sleep yang terdapat di Java
     * - Dengan menggunakan Thread Sleep, kita bisa membuat sebuah thread tertidur dan berhenti dalam waktu yang kita
     *   tentukan
     * - Untuk melakukan hal ini, kita bisa memanggil static method sleep() di class Thread, maka secara otomatis Thread
     *   saat itu dimana memanggil kode sleep() akan tertidur sesuai dengan waktu milisecond yang sudah kita masukkan dalam parameter
     * - Namun perlu diperhatikan, method sleep bisa menyebabkan error InterruptedException
     */
    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3_000);
    }

    /**
     * Thread Join
     *
     * - Kadang kita ingin menunggu sampai sebuah thread selesai tugasnya
     * - Untuk melakukan hal tersebut, kita bisa memanggil method join milik thread yang akan kita tunggu
     */
    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        thread.join();
    }

    /**
     * Thread Interrupt
     *
     * - Interrupt merupakan mengirim sinyal ke thread bahwa thread tersebut harus berhenti melakukan pekerjaannya saat
     *   ini
     * - Untuk melakukan interrupt, kita bisa menggunakan method interrupt() pada thread
     * - Saat kita memanggil method interrupt(), secara otomatis Thread.interrupted() akan bernilai true
     * - Perlu diingat, kode program kita pada Runnable harus melakukan pengecekan interrupted, jika tidak, sinyal
     *   interrupt tidak ada gunanya
     */
    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Progress selesai");
    }

    /**
     * Thread Name
     *
     * - Secara default thread di Java memiliki nama, ini sangat cocok untuk proses debugging ketika terjadi masalah
     * - Thread name secara default akan menggunakan nama Thread-{counter}
     * - Namun kita juga bisa mengubahnya dengan menggunakan method setName(name), dan getName() untuk mendapatkan nama
     *   thread nya
     */
    @Test
    void threadName() {
        var thread = new Thread(() -> System.out.println("Hello from thread : " + Thread.currentThread().getName()));
        thread.setName("ThreadCustomName");
        thread.start();
    }

    /**
     * Thread State
     *
     * - Thread di Java memiliki state, state yaitu informasi state sebuah thread
     * - State digunakan hanya untuk mendapat informasi
     * - State akan berubah statusnya sesuai dengan apa yang terjadi di thread
     * - Untuk mendapatkan data state, kita bisa menggunakan method getState() dan akan mengembalikan enum State
     */
    @Test
    void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Hello from thread : " + Thread.currentThread().getName());
        });
        System.out.println(thread.getState());
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }

    /**
     * Thread Daemon
     *
     * - Secara default, saat kita membuat thread, thread tersebut disebut user thread
     * - Java (bukan JUnit) secara default akan selalu menunggu semua user thread selesai sebelum program berhenti
     * - Jika kita mengubah thread menjadi daemon thread, menggunakan setDaemon(true), maka secara otomatis thread
     *   tersebut menjadi daemon thread
     * - Daemon thread tidak akan ditunggu jika memang program Java akan berhenti
     * - Namun jika kita menghentikan program Java menggunakan System.exit(), maka user thread pun akan otomatis terhenti
     */
    @Test
    void threadDaemon() {
        var thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Hello Daemon");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();
    }
}
