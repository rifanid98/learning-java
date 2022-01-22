package java09_java_stream.lesson05_lazy_evaluation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Lazy Evaluation
 *
 * - Stream secara default adalah lazy
 * - Dia tidak akan mengalirkan data jika belum menggunakan terminal operation
 * - Selain itu, data hanya akan dialirkan seperlunya saja, tergantung terminal operation nya
 *
 * Intermediate & Terminal Operations
 *
 * - Secara garis besar, ada 2 jenis Stream Operation, yaitu Intermediate dan Terminal Operations
 * - Intermediate Operations merupakan lazy operation, dimana Stream tidak akan dieksekusi sampai memang dibutuhkan
 * - Sedangkan Terminal Operations merupakan operasi yang mentrigger sebuah Stream berjalan
 * - Karena Intermediate Operations adalah lazy, maka secara garis besar, semua Intermediate Operations akan
 *   mengembalikan Stream lagi
 */
public class LazyEvaluationTest {

    @Test
    void testIntermediateOperations() {
        Stream<String> names = List.of("Adnin", "Rifandi", "Sutanto").stream();
        Stream<String> upperNames = names.map(name -> {
            System.out.println("Change " + name + " to UPPERCASE"); // not printed
            return name.toUpperCase();
        });
    }

    @Test
    void testTerminalOperations() {
        Stream<String> names = List.of("Adnin", "Rifandi", "Sutanto").stream();
        Stream<String> upperNames = names.map(name -> {
            System.out.println("Change " + name + " to UPPERCASE"); // printed
            return name.toUpperCase();
        });

        upperNames.forEach(upperName -> {
            System.out.println("Print Name: " + upperName); // printed
        });
    }
}
