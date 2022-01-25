package java12_date_time.lesson08_zoneid_zoneoffset;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.util.Set;

/**
 * ZoneId dan ZoneOffset
 *
 * - Sebelumnya kita sudah tahu bahwa terdapat class TimeZone di Java sebagai representasi time zone
 * - Namun di Java Date & Time API terbaru, terdapat class baru untuk mendukung time zone, yaitu ZoneId dan ZoneOffset
 */
public class ZoneIdZoneOffsetTest {

    /**
     * ZoneId
     *
     * - ZoneId mirip dengan TimeZone, dimana ini merupakan representasi time zone id
     * - Untuk mendapatkan default time zone, kita bisa menggunakan method ZoneId.systemDefault()
     * - Untuk membuat ZoneId, caranya bisa menggunakan method ZoneId.of(“Zone Id”)
     * - Dan untuk mendapatkan semua daftar time zone id yang didukung oleh Java, kita bisa menggunakan method
     */
    @Test
    void testZoneId() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneIdGMT = ZoneId.of("GMT");

        System.out.println(zoneId);
        System.out.println(zoneIdGMT);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    /**
     * ZoneOffset
     *
     * - Jika ZoneId merupakan representasi timezone menggunakan time zone id
     * - Pada class ZonenOffset, iin adalah format time zone dengan offset dari time zone Greenwich/UTC, misalnya +07:00
     *   atau -01:00
     * - Untuk membuat ZoneOffset, kita bisa menggunakan method of
     * - ZoneOffset adalah turunan dari ZoneId, jadi semua parameter yang menerima object ZoneId, bisa kita isi dengan
     *   ZoneOffset
     */
    @Test
    void testZoneOffset() {
    }
}
