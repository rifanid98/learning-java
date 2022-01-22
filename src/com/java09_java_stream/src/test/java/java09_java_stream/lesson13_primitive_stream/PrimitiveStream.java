package java09_java_stream.lesson13_primitive_stream;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Primitive Stream
 *
 * - Sebelumnya kita sudah tahu bahwa implementasi Stream di Java adalah java.util.stream.Stream<T>
 * - Namun bagaimana jika kita butuh melakukan stream terhadap data primitive seperti int, long atau double?
 * - Karena untuk Generic hanya bisa menampung tipe data Object, maka di Java Stream, dibuat implementasi Stream khusus
 *   untuk tipe data primitive
 *
 * Primitive Stream Class
 *
 * |----------------------------------------------------------------|
 * | Method                         | Keterangan                    |
 * |----------------------------------------------------------------|
 * | java.util.stream.IntStream     | Stream untuk tipe data int    |
 * | java.util.stream.LongStream    | Stream untuk tipe data long   |
 * | java.util.stream.DoubleStream  | Stream untuk tipe data double |
 * |----------------------------------------------------------------|
 *
 * Primitive Stream Operations
 *
 * - Hampir semua stream operator yang pernah kita bahas, ada juga di primitive stream class
 * - Bahkan ada beberapa operator yang lebih sederhana, seperti untuk aggregate, kita tidak perlu menggunakan comparator
 *   lagi, bahkan ada operator average() untuk menghitung rata-rata di primitive stream
 * - Cara pembuatan primitive stream pun hampir mirip dengan Stream biasa, kita bisa gunakan static method di class nya,
 *   misal IntStream.of(...), IntStream.builder(), dan lain-lain
 */
public class PrimitiveStream {

    @Test
    void testCreate() {
        IntStream intStream = IntStream.range(1, 100);
        intStream.forEach(System.out::println);

        LongStream longStream = LongStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.builder().add(0.1).add(0.2).build();
    }

    @Test
    void testOperations() {
        IntStream intStream = IntStream.range(1, 100);

        OptionalDouble optionalDouble = intStream.average();
        optionalDouble.ifPresent(System.out::println);

        IntStream.range(1, 100)
                .mapToObj(number -> "Number : " + number)
                .forEach(System.out::println);
    }
}
