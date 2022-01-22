package java09_java_stream.lesson16_parallel_stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Parallel Stream
 * <p>
 * - Salah satu fitur yang menarik di Java Stream adalah, Stream bisa dijalankan secara parallel
 * - Materi tentang Parallel Programming akan dibahas lebih detail di video tutorial Java Thread
 * - Secara garis besar, parallel artinya beberapa proses berjalan secara bersamaan
 * - Secara default, Parallel Stream akan dijalankan di ForkJoinPool, dimana akan di running secara default menggunakan
 * Thread sejumlah maksimal total CPU kita
 */
public class ParallelStreamTest {

    @Test
    void testSequential() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(number -> {
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                });
    }

    @Test
    void testParallel() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .parallel()
                .forEach(number -> {
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                });
    }
}
