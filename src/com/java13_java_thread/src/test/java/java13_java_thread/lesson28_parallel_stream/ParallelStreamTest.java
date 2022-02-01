package java13_java_thread.lesson28_parallel_stream;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Parallel Stream
 *
 * - Salah satu fitur yang menarik di Java Stream adalah, Stream bisa dijalankan secara parallel
 * - Secara default, Parallel Stream akan dijalankan di ForkJoinPool, dimana akan di running secara default menggunakan
 *   Thread sejumlah maksimal total CPU kita
 * - Agar stream bisa berjalan parallel, kita cukup gunakan method parallel()
 */
public class ParallelStreamTest {

    @Test
    void parallelStream() {
        Stream<Integer> stream = IntStream.range(0, 1000).boxed();
        stream.parallel().forEach(integer -> {
            System.out.println(Thread.currentThread().getName() + " : " + integer);
        });
    }

    /**
     * Custom ForkJoinPool
     *
     * - Method parallel() di Java Stream tidak memiliki parameter ForkJoinPool sama sekali, lantas bagaimana jika kita
     *   ingin menggunakan ForkJoinPool yang kita buat?
     * - Kita bisa mengeksekusi parallel stream nya dalam task nya ForkJoinPool
     */
    @Test
    void customForkJoinPool() {
        ForkJoinPool pool = new ForkJoinPool(1);

        ForkJoinTask<?> task = pool.submit(() -> {
            Stream<Integer> stream = IntStream.range(0, 1000).boxed();
            stream.parallel().forEach(integer -> {
                System.out.println(Thread.currentThread().getName() + " : " + integer);
            });
        });

        task.join();
    }
}
