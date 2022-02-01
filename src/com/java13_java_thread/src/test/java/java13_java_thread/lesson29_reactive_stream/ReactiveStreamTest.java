package java13_java_thread.lesson29_reactive_stream;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * Reactive Stream
 * <p>
 * - Saat ini sudah sangat populer dengan paradigma concurrency yang bernama reactive programming
 * - Banyak sekali library untuk reactive programming seperti RxJava, Reactor, Akka Stream dan lain-lain
 * - Sejak Java 9, diperkenalkan fitur Reactive Stream di Java
 * - Reactive Stream merupakan standar baru untuk Asynchronous Stream Processing
 * - Detail spesifikasinya terdapat di website http://www.reactive-streams.org/
 * <p>
 * Flow
 * <p>
 * - Dalam Reactive Stream, kita mengenal istilah namanya Flow (aliran data), berbeda dengan yang sebelumnya sudah kita
 * pelajari tentang Thread, dalam Reactive Stream, yang difokuskan adalah aliran data
 * - Dalam aliran data, artinya ada yang mengirim data dan ada yang menerima data.
 * - Pihak yang mengirim data, kita sebut Publisher, dan pihak yang menerima data, kita sebut Subscriber
 * - Sebuah aliran data, kita sebut namanya Flow
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Flow.html
 * <p>
 * Reactive Stream Class
 * <p>
 * - Implementasi dari Reactive Stream di Java disediakan dalam bentuk class Flow
 * - Untuk publisher, implementasinya menggunakan interface Flow.Publisher
 * - Dan untuk subscriber, implementasinya menggunakan interface Flow.Subscriber
 * <p>
 * Reactive Stream Library
 * <p>
 * - Reactive Stream sudah menjadi standard reactive stream programming di Java
 * - Jadi sekarang jika kita menggunakan library seperti RxJava atau Reactor, semua bisa diintegrasikan dengan Reactive
 * Stream
 * - https://github.com/ReactiveX/RxJava
 * - https://github.com/reactor/reactor-core
 */
public class ReactiveStreamTest {

    @Test
    void reactiveStream() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        var subcriber1 = new PrintSubcriber("A", 1000L);
        var subcriber2 = new PrintSubcriber("B", 500L);
        var publisher = new SubmissionPublisher<String>();
        publisher.subscribe(subcriber1);
        publisher.subscribe(subcriber2);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Data : " + i);
                System.out.println(Thread.currentThread().getName() + " Send Data : " + i);
            }
        });

//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(100 * 1000);
    }

    /**
     * Buffer
     * <p>
     * - Saat publisher mengirim data terlalu cepat, maka secara default data akan di buffer
     * - Buffer mirip antrian, dimana secara default buffer di Flow ukurannya sekitar Flow.DEFAULT_BUFFER_SIZE (256),
     * artinya jika publisher mengirim data terlalu cepat, maka buffer akan menampung data tersebut dahulu sampai sekitar 256 data, jika buffer sudah penuh, maka publisher harus menunggu sampai data di buffer di ambil oleh subscriber
     * - Jika 256 terlalu besar, kita bisa mengatur data buffer yang kita inginkan
     */
    @Test
    void buffer() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var forkJoinPool = Executors.newWorkStealingPool();
        var subcriber = new PrintSubcriber("B", 500L);
        var publisher = new SubmissionPublisher<String>(forkJoinPool, 5);
        publisher.subscribe(subcriber);

        executor.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                publisher.submit("Data : " + i);
                System.out.println(Thread.currentThread().getName() + " Send Data : " + i);
            }
            publisher.close();
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    /**
     * Processor
     * <p>
     * - Flow memiliki fitur yang bernama Processor yang direpresentasikan dalam interface Processor
     * - Processor singkatnya adalah gabungan antara Publisher dan Subscriber, jadi dia bisa menerima data dari publisher
     * lain lalu mengirim ke subscriber lain
     * - Processor cocok jika kita ingin memanipulasi data publisher lalu hasilnya dikirim ke subscriber lain
     * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/Flow.Processor.html
     */
    @Test
    void processor() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var forkJoinPool = Executors.newWorkStealingPool();
        var publisher = new SubmissionPublisher<String>(forkJoinPool, 5);

        var processor = new HelloProcessor();
        publisher.subscribe(processor);

        var subscriber = new PrintSubcriber("A", 1000L);
        processor.subscribe(subscriber);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Data : " + i);
                System.out.println(Thread.currentThread().getName() + " Send Data " + i);
            }
        });

//        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(100 * 1000);
    }
}
