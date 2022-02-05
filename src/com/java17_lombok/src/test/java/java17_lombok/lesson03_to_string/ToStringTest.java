package java17_lombok.lesson03_to_string;

import org.junit.jupiter.api.Test;

/**
 * ToString
 *
 * - Lombok juga bisa digunakan untuk membuat method toString() secara otomatis
 * - Kita bisa menggunakan annotation @ToString di class
 * - Secara otomatis akan membuat method toString() yang berisikan informasi semua field yang ada di class tersebut
 */
public class ToStringTest {

    @Test
    void toStringTest() {
        Login login = Login.createEmpty();
        login.setUsername("username");
        login.setPassword("password");
        System.out.println(login);
    }

    /**
     * Exclude Field Name
     *
     * - Kadang saat membuat method toString() kita tidak ingin menampilkan semua field
     * - Kadang ada beberapa field yang sensitif sehingga kita tidak ingin menampilkannya dalam method toString()
     * - Untuk melakukan itu, kita bisa gunakan method exclude() di annotation @ToString
     */
    @Test
    void excludeFieldName() {
        LoginExludePasswordField login = LoginExludePasswordField.createEmpty();
        login.setUsername("username");
        login.setPassword("password");
        System.out.println(login);
    }
}
