package java09_java_stream.lesson03_stream_operations;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream Operations
 *
 * - Berbeda dengan Java Collection, di Java Stream hal yang sangat menarik adalah fitur Stream Operations nya
 * - Stream Operations adalah kumpulan operasi-operasi yang bisa kita gunakan untuk memanipulasi Stream itu sendiri
 * - Ada banyak sekali jenis-jenis Stream Operations yang nanti akan kita bahas satu persatu
 * - Namun secara garis besar, Stream Operations tidak akan memodifikasi data aslinya, melainkan hasil dari Stream
 *   Operations adalah sebuah Stream baru
 */
public class StreamOperationsTest {

    @Test
    void testMapOperation() {
        List<String> names = List.of("Adnin", "Rifandi", "Sutanto");
        Stream<String> streamNames = names.stream();
        Stream<String> streamUpper = streamNames.map(name -> name.toUpperCase());
        streamUpper.forEach(System.out::println);
        names.forEach(System.out::println);
    }
}
