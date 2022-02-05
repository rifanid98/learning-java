package java16_logging.lesson01_logger;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

/**
 * Logger
 *
 * - Logger adalah class utama untuk melakukan logging
 * - Saat kita membuat Logger, biasanya kita akan menyebutkan nama Logger nya
 * - Biasanya nama logger menggunakan nama class lokasi Logger tersebut
 * - Hal ini agar mudah ketika melih`at hasil log, dari mana hasil log tersebut
 * - http://www.slf4j.org/apidocs/org/slf4j/Logger.html
 *
 * Membuat Logger
 *
 * - Untuk membuat Logger, kita tidak perlu membuat objectnya manual menggunakan new
 * - Kita bisa memanfaatkan factory class LoggerFactory
 * - http://www.slf4j.org/apidocs/org/slf4j/LoggerFactory.html
 */
public class LoggerTest {

    @Test
    void logger() {
        Logger log = LoggerFactory.getLogger(LoggerTest.class);
        log.info(() -> "Hello Log");
        log.info(() -> "Selamat Belajar Log");
    }
}
