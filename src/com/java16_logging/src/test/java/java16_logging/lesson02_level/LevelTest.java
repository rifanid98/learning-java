package java16_logging.lesson02_level;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Level
 *
 * - Log memiliki banyak level
 * - Level disini merupakan level jenis informasi log
 * - Level itu bertingkat, semakin tinggi artinya informasinya semakin penting
 * - Level juga biasanya disesuaikan dengan jenis errornya
 * - Setiap level memiliki method di logger, sehingga kita bisa gunakan level langsung di method nya
 */
public class LevelTest {

    @Test
    void level() {
        Logger log = LoggerFactory.getLogger(LevelTest.class);
        log.trace("Trace");
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
    }
}
