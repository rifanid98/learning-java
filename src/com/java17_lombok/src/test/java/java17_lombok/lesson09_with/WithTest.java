package java17_lombok.lesson09_with;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * With
 *
 * - Lombok memiliki fitur untuk membuat class baru dengan memodifikasi salah satu field yang sudah ada dengan
 *   menggunakan annotation @With
 * - Jika ditempatkan di field, maka secara otomatis akan membuat method dengan nama withXxx
 * - Jika ditempatkan di class, maka secara otomatis akan membuat method withXxx untuk semua field
 */
public class WithTest {

    @Test
    void with() {
        Register register1 = new Register("name", "password");
        Register register2 = register1.withPassword("new password");

        System.out.println(register1);
        System.out.println(register2);

        Assertions.assertNotEquals(register1, register2);
    }
}
