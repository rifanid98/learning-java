package java12_date_time.lesson03_timezone;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Consumer;

/**
 * TimeZone
 *
 * - Class TimeZone merupakan representasi dari data time zone
 * - Secara default, jika kita membuat object Calendar, dan tidak menggunakan TimeZone, secara otomatis objectnya akan
 *   menggunakan default TimeZone, yaitu timezone sistem operasi yang kita gunakan.
 * - Untuk mengetahui default time zone, kita bisa gunakan method TimeZone.getDefault()
 * - Sedangkan jika ingin membuat object TimeZone, kita bisa gunakan method TimeZone.getTimeZone(“Zone ID”)
 * - Untuk mengetahui semua zone id yang didukung oleh Java, kita bisa gunakan TimeZone.getAvailableIDs()
 *
 * TimeZone di Date
 *
 * - Class Date tidak memiliki method apapun untuk mendapatkan time zone atau mengubah time zone
 * - Secara default, saat kita membuat object Date, object tersebut akan menggunakan time zone default
 *
 * TimeZone di Calendar
 *
 * - Berbeda dengan Date, di Calendar, informasi TimeZone yang bisa kita ubah
 * - Untuk mengubah time zone di Calendar, kita bisa menggunakan method setTimeZone()
 */
public class TimezoneTest {

    @Test
    void testTimeZone() {
        TimeZone timeZoneDefault = TimeZone.getDefault();
        System.out.println(timeZoneDefault);

        TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
        System.out.println(timeZoneGMT);

        String[] availableIds = TimeZone.getAvailableIDs();
        Arrays.asList(availableIds).forEach(System.out::println);
    }

    @Test
    void testDateTimeZone() {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
    }

    @Test
    void testCalendarTimeZone() {
        Calendar calendarJKT = Calendar.getInstance(); // default timezone = Asia/Jakarta
        Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendarJKT.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

        calendarJKT.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendarJKT.get(Calendar.HOUR_OF_DAY));
    }
}
