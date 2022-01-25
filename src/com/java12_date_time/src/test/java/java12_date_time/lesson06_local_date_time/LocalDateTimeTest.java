package java12_date_time.lesson06_local_date_time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * LocalDateTime
 *
 * - Seperti dari nama class nya, LocalDateTime, class ini digunakan sebagai representasi tanggal dan waktu, mirip
 *   seperti class Date
 * - LocalDateTime juga immutable, jadi tidak bisa diubah setelah dibuat, jika diubah otomatis akan membuat object baru
 * - Cara pembuatan, cara mengubah, memanipulasi nya pun sama seperti LocalDate dan LocalTime
 * - Dan format default untuk LocalDateTime adalah menggunakan format yyyy-MM-ddTHH:mm:ss.nano
 */
public class LocalDateTimeTest {

    @Test
    void testLocalDateTime() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(1980, Month.JANUARY, 8, 10, 9, 10, 456000000);
        LocalDateTime localDateTime3 = LocalDateTime.parse("1980-01-08T10:09:10.456");

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testLocalDateTimeWith() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.withYear(1980).withMonth(1);
        LocalDateTime localDateTime3 = localDateTime1.withYear(2000).withHour(9);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testLocalDateTimeManipulation() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.plusYears(5).plusMonths(1);
        LocalDateTime localDateTime3 = localDateTime1.plusYears(10).plusHours(9);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    void testLocalDateTimeGet() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }

    /**
     * Konversi dari dan ke LocalDate
     *
     * - Kadang ada kebutuhan kita melakukan konversi data dari LocalDate ke LocalDateTime atau juga sebaliknya
     * - Untuk melakukan konversi dari LocalDateTime ke LocalDate, kita bisa menggunakan method toLocalDate()
     * - Sedangkan untuk melakukan konversi dari LocalDate ke LocalDateTime, kita bisa mennggunakann method atTime()
     */
    @Test
    void testLocalDateTimeConvertionFromAndToLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        LocalDateTime result = localDate.atTime(10, 10, 10, 10);
        System.out.println(result);
    }

    /**
     * Konversi dari dan ke LocalTime
     *
     * - Selain melakukan konnversi untuk tipe data LocalDate, kita juga bisa lakukan ke dan dari tipe data LocalTime.
     * - Untuk melakukan konversi dari LocalDateTime ke LocalTime, kita bisa menggunakan method toLocalTime()
     * - Sedangkan untuk melakukan konversi dari LocalTime ke LocalDateTime, kita bisa mennggunakann method atDate()
     */
    @Test
    void testLocalDateTimeConvertionFromAndToLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

        LocalDateTime result = localTime.atDate(LocalDate.now());
        System.out.println(result);
    }
}
