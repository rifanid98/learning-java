package java12_date_time.lesson18_legacy_date_and_time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Legacy Date dan Time
 *
 * - Saat fitur Java Date & Time API baru keluar, Java juga menambahkan integrasi dengan fitur legacy date dan time yang
 *   menggunakan Date, Calendar dan TimeZone
 * - Kita bisa melakukan konversi dari tipe temporal legacy ke tipe temporal baru ataupun sebaliknya
 */
public class LegacyDateAndTimeTest {

    @Test
    void testLegacyAndDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(date);
        System.out.println(instant);

        Calendar calendar = Calendar.getInstance();
        Instant instant1 = calendar.toInstant();
        System.out.println(calendar);
        System.out.println(instant1);

        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
        System.out.println(timeZone);
        System.out.println(zoneId);
    }

    @Test
    void testNewClassToLegacyClassConversion() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);

        Calendar calendar = GregorianCalendar.from(zonedDateTime);
        System.out.println(calendar);

        ZoneId zoneId = ZoneId.systemDefault();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone);
    }
}
