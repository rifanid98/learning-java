package java09_java_stream.lesson06_transformation_operations;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Transformation Operations
 *
 * - Ada banyak Stream Operations di Java Stream, kita akan mulai bahas dari Transformation Operations
 * - Transformation Operations adalah operasi yang digunakan untuk mengubah bentuk Stream
 * - Ada banyak function yang bisa digunakan untuk mengubah bentuk Stream menjadi sebuah Stream baru, contohnya map dan
 *   flatMap
 *
 * Method Transfrmation Operations
 *
 * |-----------------------------------------------------------------|
 * | Method                     | Keterangan                         |
 * |-----------------------------------------------------------------|
 * | map(T -> U)                | Mengubah Stream T menjadi Stream U |
 * | flatMap(T -> Stream<U>)    | Mengubah Stream T menjadi Stream U |
 * |-----------------------------------------------------------------|
 */
public class TransformationOperationsTest {

    /**
     * Map satu data ke data yang lain
     *
     * ex: adnin -> Adnin
     * res: Adnin
     */
    @Test
    void testMapOperation() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .map(name -> name.toUpperCase())
                .map(upper -> upper.length())
                .forEach(length -> System.out.println(length));
    }

    /**
     * Map satu data ke Stream yang lain.
     * Setiap Stream akan dimerge dengan Stream yang lain
     *
     * ex: adnin -> Stream.of(adnin, adnin.length)
     * res: adnin, 5
     */
    @Test
    void testFlatMapOperation() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .map(name -> name.toUpperCase())
                .flatMap(upper -> Stream.of(upper, upper.length()))
                .forEach(length -> System.out.println(length));
    }
}
