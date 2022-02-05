package java17_lombok.lesson10_cleanup;

import org.junit.jupiter.api.Test;

/**
 * Cleanup
 * <p>
 * - Saat kita menggunakan object resource di Java yang perlu di close (seperti misal koneksi ke database), biasanya
 * kita akan menggunakan try finally
 * - Lombok memiliki fitur yang bisa kita gunakan untuk membuat auto generate close resource, yaitu annotation @Cleanup
 */
public class CleanupTest {

    @Test
    void cleanup() throws Exception {
        String text = FileHelper.loadFile("pom.xml");
        System.out.println(text);
    }
}
