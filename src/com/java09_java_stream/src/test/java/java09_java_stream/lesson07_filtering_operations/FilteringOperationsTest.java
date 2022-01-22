package java09_java_stream.lesson07_filtering_operations;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Filtering Operations
 *
 * - Filtering operations adalah operasi di Stream yang digunakan untuk melakukan filter data Stream
 * - Contohnya, misal kita punya Stream data dari 1 sampai 10, lalu kita misal hanya ingin menggunakan data yang ganjil
 *   atau genap saja
 *
 * Method Filtering Operations
 *
 * |--------------------------------------------------------------------|
 * | Method                 | Keterangan                                |
 * |--------------------------------------------------------------------|
 * | filter(T -> Boolean)   | Mengambil data yang masuk kriteria filter |
 * | distinct()             | Menghapus semua data duplikat             |
 * |--------------------------------------------------------------------|
 */
public class FilteringOperationsTest {

    @Test
    void testFilter() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .filter(name -> name.length() > 5)
                .forEach(System.out::println); // Rifandi, Sutanto

        List.of(1,1,2,2,3).stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println); // 2
    }

    @Test
    void testDistinct() {
        List.of("Adnin", "Adnin", "Rifandi", "Rifandi", "Sutanto").stream()
                .distinct()
                .forEach(System.out::println); // Adnin, Rifandi, Sutanto
    }
}
