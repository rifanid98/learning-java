package java16_logging.lesson03_log_format;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log Format
 *
 * - Kadang kita ingin menggunakan parameter saat melakukan logging
 * - Biasanya kita akan membuat string concat untuk membuat pesan logging nya
 * - Namun SLF4J sudah menyediakan log format
 * - Kita bisa menggunakan beberapa method overloading nya
 */
public class LogFormatTest {

    @Test
    void logFormat() {
        Logger log = LoggerFactory.getLogger(LogFormatTest.class);
        log.info("Without Parameter");
        log.info("{} + {} = {}", 10, 10, (10 + 10));
        log.error("Ups", new NullPointerException());
    }
}
