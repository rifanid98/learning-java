package java16_logging.lesson05_appender;

import java16_logging.lesson02_level.LevelTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Appender
 *
 * - Saat kita melakukan logging, kita bisa menentukan destinasi log file yang akan dibuat, atau dinamakan Appender
 * - Logback sudah menyediakan banyak sekali appender, jadi sebenarnya kita tidak perlu membuat appender secara manual
 * - http://logback.qos.ch/apidocs/ch/qos/logback/core/Appender.html
 */
public class AppenderTest {

    @Test
    void appender() {
        Logger log = LoggerFactory.getLogger(LevelTest.class);
        log.trace("Trace");
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
    }
}
