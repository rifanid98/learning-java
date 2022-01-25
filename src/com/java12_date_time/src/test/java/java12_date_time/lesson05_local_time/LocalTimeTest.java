package java12_date_time.lesson05_local_time;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

/**
 * LocalTime
 *
 * - Berbeda dengan LocalDate, LocalTime merupakan representasi data waktu (tanpa tanggal)
 * - Cara penggunaanya dan method-method nya hampir sama dengan LocalDate
 * - LocalTime juga immutable, jadi kita tidak bisa mengubahnya setelah datanya dibuat, jika kita ubah, maka akan
 *   menghasilkan object LocalTime baru
 * - Format standard LocalTime adalah HH:mm:ss.nano, dimana second dan nano second nya optional
 */
public class LocalTimeTest {

    @Test
    void testLocalTime() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(10,10,10);
        LocalTime localTime3 = LocalTime.parse("10:10");

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void testLocalTimeWith() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.withHour(20);
        LocalTime localTime3 = localTime1.withHour(20).withMinute(20);

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void testLocalTimeManipulation() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.plusHours(10);
        LocalTime localTime3 = localTime1.plusHours(10).plusMinutes(10);

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void testLocalTimeGet() {
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
    }
}
