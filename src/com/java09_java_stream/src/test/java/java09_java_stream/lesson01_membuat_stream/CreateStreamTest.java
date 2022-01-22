package java09_java_stream.lesson01_membuat_stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Membuat Stream
 * <p>
 * - Ada banyak cara untuk membuat Stream di Java
 * - Bisa membuat langsung Stream dari Array, atau dari Collection
 */
public class CreateStreamTest {

    @Test
    void testCreateEmptyOrSingleStream() {
        Stream<String> emptyStream = Stream.empty();
        Stream<String> oneStream = Stream.of("Eko");
        Stream<String> emptyOrNotStream = Stream.ofNullable(null);
    }

    @Test
    void testCreateStreamFromArray() {
        Stream<String> streamString = Stream.of("Adnin", "Rifandi", "Sutanto", "Putra");
        Stream<Integer> streamInteger = Stream.of(1, 2, 3, 4, 5);

        String[] array = new String[]{
                "Adnin", "Rifandi", "Sutanto", "Putra"
        };
        Stream<String> streamFromArray = Arrays.stream(array);
    }

    /**
     * Menjalankan Stream
     * <p>
     * - Secara default, Stream itu bersifat Cold, artinya data di Stream tidak akan mengalir sampai kita memintanya
     * - Ada banyak cara untuk meminta Stream mulai mengalirkan datanya, hal ini akan kita bahas di bagian Stream
     * Operations
     * - Untuk saat ini, salah satu method yang bisa kita gunakan agar aliran data di Stream mengalir adalah menggunakan
     * method forEach
     * - Stream hanya bisa jalan sekali, mirip seperti aliran data, setelah mengalir, aliran data tidak bisa diulang
     * lagi dari awal
     */
    @Test
    void runStream() {
        Stream<String> streamString = Stream.of("Adnin", "Rifandi", "Sutanto", "Putra");
        Stream<Integer> streamInteger = Stream.of(1, 2, 3, 4, 5);

        String[] array = new String[]{
                "Adnin", "Rifandi", "Sutanto", "Putra"
        };
        Stream<String> streamFromArray = Arrays.stream(array);

        streamString.forEach(value -> {
            System.out.println(value);
        });

        streamInteger.forEach(value -> {
            System.out.println(value);
        });

        streamFromArray.forEach(value -> {
            System.out.println(value);
        });
    }

    @Test
    void testCreateStreamFromCollection() {
        Collection<String> collection = List.of("Adnin", "Rifandi", "Sutanto", "Putra");
        Stream<String> stringStream = collection.stream();
        stringStream.forEach(System.out::println);
        // stringStream.forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated
    }

    @Test
    void testCreateStreamIterate() {
        Stream<String> stream1 = Stream.generate(() -> "String");
        // stream1.forEach(System.out::println); // infinite foreach

        Stream<Integer> stream2 = Stream.iterate(1, value -> value + 1);
        // stream2.forEach(System.out::println); // infinite foreach
    }
}
