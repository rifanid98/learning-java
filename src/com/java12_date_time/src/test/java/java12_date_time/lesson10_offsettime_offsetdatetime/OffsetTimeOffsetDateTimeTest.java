package java12_date_time.lesson10_offsettime_offsetdatetime;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * OffsetTime dan OffsetDateTime
 *
 * - Java Date & Time API memiliki class yang bernama OffsetTime dan OffsetDateTime
 * - Class OffsetTime adalah seperti LocalTime, namun memiliki time zone offset
 * - Dan Class OffsetDateTime adalah seperti LocalDateTime, namun memiliki time zone offset
 * - Sekilas OffsetDateTime mirip dengan ZonedDateTime, yang membedakan adalah kalo OffsetDateTime hanya bisa menggunakan
 *   ZoneOffset, tidak bisa menggunakan ZoneId
 * - Format default OffsetTime adalah HH:mm:ss(+/-)ZoneOffset
 * - Format default OffsetDateTime adalah yyyy-MM-ddTHH:mm:ss(+/-)ZoneOffset
 */
public class OffsetTimeOffsetDateTimeTest {

    @Test
    void testOffisetTimeOffsetDateTime() {
        OffsetTime offsetTime1 = OffsetTime.now();
        OffsetTime offsetTime2 = OffsetTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetTime offsetTime3 = OffsetTime.of(10, 10, 10, 10, ZoneOffset.ofHours(7));
        OffsetTime offsetTime4 = OffsetTime.parse("09:09:09.100+07:00");

        System.out.println(offsetTime1);
        System.out.println(offsetTime2);
        System.out.println(offsetTime3);
        System.out.println(offsetTime4);

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetDateTime offsetDateTime3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));
        OffsetDateTime offsetDateTime4 = OffsetDateTime.parse("1980-09-17T10:10:10.100+05:00");

        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime3);
        System.out.println(offsetDateTime4);
    }

    /**
     * Konversi ke dan dari Non Offset
     *
     * - Apa yang bisa kita lakukan di LocalTime dan LocalDateTime bisa juga dilakukan di OffsetTime dan OffsetDateTime
     * - Selain itu kita juga bisa konversi data dari dan ke non offset
     */
    @Test
    void testToAndFromNonOffsetConversion() {
        LocalTime localTime = LocalTime.now();
        OffsetTime offsetTime = localTime.atOffset(ZoneOffset.ofHours(7));
        LocalTime localTime11 = offsetTime.toLocalTime();

        System.out.println(localTime);
        System.out.println(offsetTime);
        System.out.println(localTime11);

        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(7));
        LocalDateTime localDateTime1 = offsetDateTime.toLocalDateTime();

        System.out.println(localDateTime);
        System.out.println(offsetDateTime);
        System.out.println(localDateTime1);
    }
}
