package java12_date_time.lesson04_local_date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * LocalDate
 *
 * - LocalDate adalah class di Date & Time API baru
 * - LocalDate merupakan representasi untuk tipe data tanggal (tanpa waktu)
 * - Default format waktu untuk LocalDate adalah yyyy-MM-dd
 *
 */
public class LocalDateTest {

    @Test
    void testLocalDate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(1980, Month.JANUARY, 10);
        LocalDate localDate3 = LocalDate.parse("1980-01-10");

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
    }

    /**
     * Mengubah LocalDate
     *
     * - Object LocalDate juga bisa kita ubah tanggal nya jika kita mau
     * - Untuk mengubah tanggal, kita bisa menggunakan method with, seperti withYear, withMonth, dan lain-lain
     * - Perlu diingat, mengubah LocalDate akan menciptakan object LocalDate baru, artinya object aslinya tidak akan berubah,
     *   karena bersifat immutable
     */
    @Test
    void testLocalDateWith() {
        LocalDate localDate1 = LocalDate.now(); // immutable
        LocalDate localDate2 = localDate1.withYear(1980); // copied from localDate1 with Year 1980
        LocalDate localDate3 = localDate1.withYear(1980).withMonth(10);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
    }

    /**
     * Manipulasi LocalDate
     *
     * - Object LocalDate juga bisa kita manipulasi, seperti menambah tanggal atau mengurangi tanggal.
     * - Untuk menambah tanggal, kita bisa gunakan method plus, seperti plusYears, plusMonths, plusDays, dan lain-lain
     * - Untuk mengurangi tanggal, kita bisa gunakan method minus, seperti minusYears, minusMonths, minusDays, dan lain-lain
     * - Perlu diingat, manipulasi LocalDate akan menciptakan object LocalDate baru, artinya object aslinya tidak akan berubah,
     *   karena bersifat immutable
     */
    @Test
    void testLocalDateManipulation() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.plusYears(10);
        LocalDate localDate3 = localDate1.plusMonths(10);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
    }

    /**
     * Mengambil Tanggal LocalDate
     *
     * - LocalDate juga mendukung pengambilan detail data tanggal nya, seperti tahun, bulan, hari dalam bulan, hari dalam
     *   tahun, dan lain-lain
     * - Untuk mengambil data tanggal, kita bisa menggunakan method get, seperti getYear, getMonth, dan lain-lain
     */
    @Test
    void testLocalDateGet() {
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
    }
}
