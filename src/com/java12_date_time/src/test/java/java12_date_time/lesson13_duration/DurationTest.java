package java12_date_time.lesson13_duration;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Duration
 *
 * - Class Duration adalah representasi dari data durasi waktu
 * - Durasi waktu yang terdapat di class Duration
 * - Dengan menggunakan Duration, kita bisa dengan mudah mengkonversi durasi ke waktu yang kita inginkan, misal hour,
 *   minute, second dan nano second
 */
public class DurationTest {

    @Test
    void testDuration() {
        Duration duration1 = Duration.ofSeconds(10);
        Duration duration2 = Duration.ofMillis(10);
        Duration duration3 = Duration.ofHours(10);

        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
    }

    @Test
    void testDurationGet() {
        Duration duration = Duration.ofHours(10);

        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toNanos());
    }

    @Test
    void testDurationCalculate() {
        Duration duration1 = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        System.out.println(duration1.toHours());
        System.out.println(duration1.toMinutes());

        Duration duration2 = Duration.between(LocalDateTime.now().plusHours(10), LocalDateTime.now());
        System.out.println(duration2.toHours());
        System.out.println(duration2.toMinutes());
    }
}
