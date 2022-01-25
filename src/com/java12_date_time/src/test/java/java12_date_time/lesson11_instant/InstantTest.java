package java12_date_time.lesson11_instant;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * Instant
 *
 * - Sebelumnya, milliseconds direpresentasikan dengan tipe data long, di Java Date & Time API baru, implementasi
 *   milliseconds direpresentasikan dalam class Instant
 * - Instant juga sama seperti class Date, dia menggunakan milliseconds  setelah Unix EPOCH 1970-01-01T00:00:00Z
 * - Artinya secara time zone, Instant menggunakan time zone UTC (00:00)
 */
public class InstantTest {

    @Test
    void testInstant() {
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis());

        System.out.println(instant1);
        System.out.println(instant2);
    }

    @Test
    void testInstantManipulation() {
        Instant instant1 = Instant.now();
        Instant instant2 = instant1.plusMillis(1000);
        Instant instant3 = instant1.minusMillis(1000);

        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
    }

    @Test
    void testInstantGet() {
        Instant instant = Instant.now();

        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
    }

    /**
     * Konversi dari Instant
     *
     * - Karena Instant berisikan milisecond, jadi kita bisa lakukan konversi ke tipe data lainnya, seperti LocalDate,
     *   LocalTime dan ZonedLocalTime
     * - Namu karena Instant menggunakann time zone UTC, jadi kita perlu memberi tahu time zone apa yang akan kita
     *   gunakan ketika kita lakukan konversi
     * - Untuk melakuka konversi dari Instant ke tipe data lainnya, kita bisa menggunakan method ofInstant(instant, zone)
     *   ketika membuat object nya
     */
    @Test
    void testConversionFromInstant() {
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Asia/Jakarta");

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalTime localTime = LocalTime.ofInstant(instant, zoneId);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, zoneId);

        System.out.println(localDateTime);
        System.out.println(localTime);
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);
    }

    /**
     * Konversi ke Instant
     *
     * - Selain itu konversi juga bisa dilakukan ke Instant, dari tipe data LocalDateTime dan ZonedDateTime
     * - Namun karena Instant menggunakan time zone UTC, jadi kita perlu menambahkan ZoneOffset jika konversi dari tipe
     *   data yang tidak memiliki time zone
     */
    @Test
    void testConversionToInstant() {
        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
        Instant instant2 = ZonedDateTime.now().toInstant();
        Instant instant3 = OffsetDateTime.now().toInstant();

        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
    }
}
