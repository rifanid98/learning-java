package java12_date_time.lesson09_zoneddatetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * ZonedDateTime
 *
 * - Pada class LocalDateTime, secara default tidak ada informasi time zone sama sekali pada class tersebut
 * - Jika kita ingin membuat tanggal dan waktu yang mendukung time zone, kita bisa menggunakan class ZonedDateTime
 * - Class ZonedDateTime sama seperti LocalDateTime, perbedaannya hanyalah mendukung time zone
 * - Format default untuk ZonedDateTime adalah yyyy-MM-ddTHH:mm:ss.nano(+/-)ZoneOffset[ZoneId], dimana ZoneId tidak
 *   wajib, dan jika ZoneId diisi, maka nilai ZoneOffset akan di hiraukan
 */
public class ZonedDateTimeTest {

    @Test
    void testZonedDateTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));
        ZonedDateTime zonedDateTime4 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
        System.out.println(zonedDateTime4);
    }

    @Test
    void testZonedDateTimeParse() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2022-01-25T16:07:50.439174750+07:00[Asia/Jakarta]");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2022-01-25T09:07:50.439389623Z[GMT]");

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
    }

    /**
     * Mengubah Time Zone
     *
     * - Untuk mengubah time zone pada ZonedDateTime, terdapat dua cara
     * - Pertama, mengubah time zone, tanpa merubah tanggal dan waktu. Caranya dengan menggunakan method
     *   withZoneSameLocal(ZoneId)
     * - Kedua, mengubah time zone, sehingga tanggal dan waktu mengikuti timezone yang baru. Caranya dengan menggunakan
     *   method withZoneSameInstance(ZoneId)
     */
    @Test
    void testZonedDateTimeModify() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameLocal(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime3 = zonedDateTime1.withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }
}
