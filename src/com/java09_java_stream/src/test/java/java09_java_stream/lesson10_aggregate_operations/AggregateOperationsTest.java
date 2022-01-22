package java09_java_stream.lesson10_aggregate_operations;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Aggregate Operations
 *
 * - Java Stream mendukung banyak operasi untuk melakukan proses aggregate
 * - Seperti menghitung jumlah data, menghitung data max dan menghitung data min.
 *
 * Method Aggregate Operations
 *
 * |------------------------------------------------------------|
 * | Method             | Keterangan                            |
 * |------------------------------------------------------------|
 * | max(Comparator)    | Mencari data max sesuai comparator    |
 * | min(Comparator)    | Mencari data min sesuai comparator    |
 * | count()            | Menghitung total data                 |
 * |------------------------------------------------------------|
 *
 * Manual Aggregate Menggunakan Reduce
 *
 * - Java Stream juga menyediakan sebuah operasi yang bernama reduce
 * - Reduce bisa digunakan untuk melakukan proses aggregate secara manual
 * - Misal kita ingin menjumlahkan seluruh angka yang terdapat di Stream, kita bisa melakukan ini menggunakan reduce
 *   operator
 * - Di bahasa pemrograman lain, reduce mirip seperti operasi fold
 */
public class AggregateOperationsTest {

    @Test
    void testMax() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println); // Sutanto
    }

    @Test
    void testMin() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println); // Adnin
    }

    @Test
    void testCount() {
        long count = List.of("Adnin", "Rifandi", "Sutanto").stream()
                .count();

        System.out.println(count); // 3
    }

    @Test
    void testReduce() {
       var result  =  List.of(1, 2, 3, 4, 5).stream()
                .reduce(0, (temp, current) -> temp + current); // 15

        System.out.println(result);

        // 0
        // 1. temp=0 current=1 = 1
        // 2. temp=1 current=2 = 3
        // 3. temp=3 current=3 = 6
        // 4. temp=6 current=4 = 10
        // 5. temp=10 current=5 = 15
    }
}
