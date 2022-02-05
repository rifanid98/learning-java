package java17_lombok.lesson12_log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

/**
 * Log
 *
 * - Saat membuat aplikasi, kita sering sekali membuat log, dan juga otomatis sering sekali membuat field untuk Logger nya
 * - Lombok mendukung pembuatan field log secara otomatis menggunakan annotation log, ada banyak yang didukung oleh Lombok,
 *   seperti @Log untuk Java Logging, @Slf4j untuk SLF4J, @CommonsLog untuk apache commons log, @Flogger untuk Google Flogger, @Log4J untuk Log4J, @JbossLog untuk JBoss Log
 * - Secara otomatis Lombok akan membuat field bernama log sesuai dengan logger library yang kita gunakan
 */
public class LogTest {

    @Test
    void log() {
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            String text = FileHelper.loadFile("pom.xmls");
            System.out.println(text);
        });
    }
}
