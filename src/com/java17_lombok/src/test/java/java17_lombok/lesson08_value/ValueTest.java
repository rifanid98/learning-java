package java17_lombok.lesson08_value;

import org.junit.jupiter.api.Test;

/**
 * Value
 *
 * - Kadang kita sering membuat sebuah class yang bersifat immutable (tidak bisa diubah lagi ketika sudah dibuat)
 * - Biasanya yang kita lakukan adalah, menjadikan semua field nya final, tidak membuat setter method dan membuat
 *   constructor untuk semua field
 * - Lombok memiliki fitur yang bisa kita gunakan untuk membuat immutable class, yaitu menggunakan annotation @Value
 */
public class ValueTest {

    @Test
    void value() {
        Register register = new Register("name", "password");
        // register.setPassword("new password"); // not exists, immutable
        System.out.println(register);
    }
}
