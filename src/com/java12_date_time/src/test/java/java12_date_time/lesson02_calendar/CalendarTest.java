package java12_date_time.lesson02_calendar;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar
 *
 * - Class Calendar adalah class yang digunakan sebagai pembantu class Date
 * - Pada class Date, hampir semua method untuk melakukan manipulasi tanggal dan waktu sudah ditandai sebagai @Deprecated,
 *   artinya tidak direkomendasikan digunakan lagi
 * - Untuk itu, kita butuh menggunakan class Calendar untuk memanipulasi tanggal dan waktu
 * - Class Calendar tidak memiliki public constructor, sehingga untuk membuat object Calendar, kita akan menggunakan
 *   static method milik calendar bernama getInstance()
 */
public class CalendarTest {

    @Test
    void testCalendar() {
        var calendar = Calendar.getInstance();
        var date = calendar.getTime();
        System.out.println(date);
    }

    /**
     * Manipulasi Tanggal dan Waktu
     *
     * - Salah satu fitur yang terdapat di Calendar adalah, kita bisa melakukan manipulasi tanggal dan waktu di object
     *   Calendar menggunakan method set(type, value)
     * - Dan untuk mengambil value tanggal atau waktu, kita bisa menggunakan method get(type)
     */
    @Test
    void testModifyCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,  1980);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 30);

        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    void testGetCalendar() {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
    }
}
