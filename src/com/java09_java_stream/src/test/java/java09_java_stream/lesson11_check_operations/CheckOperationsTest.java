package java09_java_stream.lesson11_check_operations;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Check Operations
 *
 * - Check Operations adalah operasi yang digunakan untuk melakukan pengecekan data di dalam Stream
 * - Ada banyak sekali operasi yang bisa digunakan untuk melakukan pengecekan
 * - Dan hasil operasi check adalah boolean
 *
 * Method Check Operations
 *
 * |------------------------------------------------------------------------------------|
 * | Method                     | Keterangan                                            |
 * |------------------------------------------------------------------------------------|
 * | anyMatch(T -> Boolean)     | Apakah ada salah satu data yang match dengan kondisi  |
 * | allMatch(T -> Boolean)     | Apakah semua data match dengan kondisi                |
 * | noneMoatch(T -> Boolean)   | Apakah semua data tidak match dengan kondisi          |
 * |------------------------------------------------------------------------------------|
 */
public class CheckOperationsTest {

    @Test
    void testAnyMatch() {
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .anyMatch(number -> number > 5);

        System.out.println(match); // true
    }

    @Test
    void testAllMatch() {
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .allMatch(number -> number > 20);

        System.out.println(match); // false
    }

    @Test
    void testNoneMatch() {
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .noneMatch(number -> number > 20);

        System.out.println(match); // true
    }
}
