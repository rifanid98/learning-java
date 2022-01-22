package java09_java_stream.lesson12_foreach_operations;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * For Each Operations
 *
 * - Untuk mengiterasi data satu persatu, sebelumnya kita sudah sering menggunakan operasi forEach
 * - Selain forEach, ada juga method untuk melakukan for each, tapi tanpa harus melakukan terminal operation
 *
 * Method For Each Operations
 *
 * |---------------------------------------------------------------------------------------------------------|
 * | Method                 | Keterangan                                                                     |
 * |---------------------------------------------------------------------------------------------------------|
 * | forEach(T -> void)     | Melakukan iterasi satu per satu data di Stream, mengembalikan void.            |
 * |                        | Ini adalah terminal operation                                                  |
 * | peek(T -> Stream<T>)   | Melakukan iterasi satu per satu data di Stream, tapi Mengembalikan Stream lagi |
 * |---------------------------------------------------------------------------------------------------------|
 */
public class ForEachOperationsTest {

    @Test
    void testPeekBefore() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .map(name -> {
                    System.out.println("before change name to upper : " + name);
                    String upper = name.toUpperCase();
                    System.out.println("change name to upper : " + upper);
                    return upper;
                })
                .forEach(name -> System.out.println("final name : " + name));
    }

    @Test
    void testPeekAfter() {
        List.of("Adnin", "Rifandi", "Sutanto").stream()
                .peek(name -> System.out.println("before change name to upper : " + name))
                .map(name -> name.toUpperCase())
                .peek(upper -> System.out.println("change name to upper : " + upper))
                .forEach(name -> System.out.println("final name : " + name));
    }
}
