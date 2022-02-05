package java17_lombok.lesson11_sneaky_throws;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

/**
 * Sneaky Throws
 * <p>
 * - Secara default saat kita membuat kode yang memiliki checked exception, kita perlu menangkapnya dalam try-catch
 * - Lombok bisa secara pindah mengubah checked exception menjadi runtime exception tanpa mengubah exception nya itu
 * sendiri
 * - Lombok hanya mengakali agar compiler Java tidak komplen ketika kita tidak menangkap checked exception
 * - Untuk melakukan itu, kita bisa menggunakan annotation @SneakyThrows
 */
public class SneakyThrowsTest {

    @Test
    void sneakyThrows() {
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            String text = FileHelper.loadFile("pom.xmls");
            System.out.println(text);
        });
    }
}
