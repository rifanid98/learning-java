package java09_java_stream.lesson08_retrieving_operations;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * Retrieving Operations
 *
 * - Retrieving Operations adalah operasi pada Stream untuk melakukan pengambilan sebagian data
 * - Secara garis besar, cara kerjanya hampir mirip dengan Filtering
 *
 * Method Retrieving Operations
 *
 * |--------------------------------------------------------------------|
 * | Method                     | Keterangan                            |
 * |--------------------------------------------------------------------|
 * | limit(n)                   | Mengambil sejumlah n data             |
 * | skip(n)                    | Menghiraukan sejumlah n data          |
 * | takeWhile(T -> Boolean)    | Mengambil data selama kondisi true    |
 * | dropWhile(T -> Boolean)    | Menghiraukan data selama kondisi true |
 * |--------------------------------------------------------------------|
 *
 * Retrieving Single Element
 *
 * - Stream juga memiliki kemampuan untuk mengambil satu element saja
 * - Namun operasi jenis ini merupakan operasi terminal, sehingga akan secara otomatis menjalankan aliran data di Stream
 *
 * Method Retrieving Single Element
 *
 * |------------------------------------------------|
 * | Method         | Keterangan                    |
 * |------------------------------------------------|
 * | findAny(n)     | Mengambil random satu element |
 * | findFirst(n)   | Mengambil element pertama     |
 * |------------------------------------------------|
 */
public class RetrievingOperationsTest {

    @Test
    void testLimit() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .limit(2)
                .forEach(System.out::println); // Adnin, Rifandi
    }

    @Test
    void testSkip() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .skip(2)
                .forEach(System.out::println); // Sutanto
    }

    @Test
    void testTakeWhile() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .takeWhile(name -> name.length() < 6)
                .forEach(System.out::println); // Adnin
    }

    @Test
    void testDropWhile() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .dropWhile(name -> name.length() < 6)
                .forEach(System.out::println); // Rifandi, Sutanto
    }

    @Test
    void testFindAny() {
        Optional<String> optional = List.of("Adnin", "Rifandi", "Sutanto").stream()
                .findAny();

        optional.ifPresent(System.out::println); // random value
    }

    @Test
    void testFindFirst() {
        Optional<String> optional = List.of("Adnin", "Rifandi", "Sutanto").stream()
                .findFirst();

        optional.ifPresent(System.out::println); // Adnin
    }
}
