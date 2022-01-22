package java09_java_stream.lesson09_ordering_operations;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Ordering Operations
 *
 * - Java Stream juga mendukung operasi untuk melakukan pengurutan data Stream nya
 * - Secara default, data akan diurutkan mengikuti Comparable yang terdapat di data yang ada di Stream
 * - Jika kita ingin mengurutkan secara manual, kita bisa menggunakan Comparator sendiri
 *
 * Method Ordering Operations
 *
 * |----------------------------------------------------------------|
 * | Method             | Keterangan                                |
 * |----------------------------------------------------------------|
 * | sorted()           | Mengurutkan berdasarkan comparable data   |
 * | sorted(Comparator) | Mengurutkan berdasarkan comparator        |
 * |----------------------------------------------------------------|
 */
public class OrderingOperationsTest {

    @Test
    void testSorted() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .sorted()
                .forEach(System.out::println); // Adnin, Rifandi, Sutanto
    }

    @Test
    void testSortedWithComparator() {
        Comparator<String> reverseComparator = Comparator.reverseOrder();

        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .sorted(reverseComparator)
                .forEach(System.out::println); // Sutanto, Rifandi, Adnin
    }
}
