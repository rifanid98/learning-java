package java12_date_time.lesson16_day_of_week;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

/**
 * DayOfWeek
 *
 * - Yang menarik di Java Date & Time adalah, memiliki implementasi data hari
 * - Data hari ini beruba Enum DayOfWeek, namun dia adalah turunan dari Temporal, sehingga operasi yang bisa dilakukan
 *   di Temporal bisa kita lakukan disini, seperti menambah atau mengurangi
 */
public class DayOfWeekTest {

    @Test
    void testDayOfWeek() {
        DayOfWeek dayOfWeek1 = DayOfWeek.SUNDAY;
        DayOfWeek dayOfWeek2 = dayOfWeek1.plus(7);
        DayOfWeek dayOfWeek3 = dayOfWeek1.plus(1);

        System.out.println(dayOfWeek1);
        System.out.println(dayOfWeek2);
        System.out.println(dayOfWeek3);
    }
}
