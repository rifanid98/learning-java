package java16_logging.lesson04_configuration;

import java16_logging.lesson02_level.LevelTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration
 *
 * - Secara default, saat kita menggunakan logback, kita tidak butuh configuration
 * - Namun kadang-kadang kita ingin menggunakan configuration
 * - Misal, ketika di laptop kita ingin menjalankan logging sampai ke level trace, namun ketika production misal kita
 *   hanya butuh di level warning agar tidak terlalu banyak log
 * - Hal tersebut, perlu kita lakukan dengan membuat file konfigurasi
 */
public class ConfigurationTest {

    @Test
    void configuration() {
        Logger log = LoggerFactory.getLogger(LevelTest.class);
        log.trace("Trace");
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
    }
}
