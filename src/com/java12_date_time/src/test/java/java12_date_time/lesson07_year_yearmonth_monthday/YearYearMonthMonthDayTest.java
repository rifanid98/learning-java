package java12_date_time.lesson07_year_yearmonth_monthday;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * Year, YearMonth dan MonthDay
 *
 * - Di Date & Time API baru, terdapat class Year , YearMonth dan MonthDay
 * - Seperti dari nama class nya, Year digunakan untuk tanggal yang hanya berisi data tahun, dan YearMonth adalah
 *   tanggal yang berisi data tahun dan bulan, dan MonthDay adalah tanggal berisi bulan dan hari
 * - Kenapa menggunakan Year? Kenapa tidak langsung menggunakan angka saja? Misal 2020. Di Year, sudah banyak sekali
 *   method yang bisa kita gunakan untuk manipulasi data tanggal dan konversi ke tipe lain seperti LocalDate misal nya
 * - Begitu juga dengan YearMonth dan MonthDay
 * - Format default untuk Year adalah yyyy dan format untuk YearMonth adalah yyyy-MM dan format untuk MonthDay adalah
 *   --MM-dd
 */
public class YearYearMonthMonthDayTest {

    @Test
    void testYearYearMonthMonthDay() {
        Year year1 = Year.now();
        Year year2 = Year.of(1980);
        Year year3 = Year.parse("2020");

        System.out.println(year1);
        System.out.println(year2);
        System.out.println(year3);

        YearMonth yearMonth1 = YearMonth.now();
        YearMonth yearMonth2 = YearMonth.of(1980, Month.JANUARY);
        YearMonth yearMonth3 = YearMonth.parse("2020-09");

        System.out.println(yearMonth1);
        System.out.println(yearMonth2);
        System.out.println(yearMonth3);

        MonthDay monthDay1 = MonthDay.now();
        MonthDay monthDay2 = MonthDay.of(Month.JANUARY, 10);
        MonthDay monthDay3 = MonthDay.parse("--01-10");

        System.out.println(monthDay1);
        System.out.println(monthDay2);
        System.out.println(monthDay3);
    }

    @Test
    void testYearToLocalDateConvertion() {
        Year year = Year.now();
        System.out.println(year);

        LocalDate localDate = year.atMonth(Month.JANUARY).atDay(19);
        System.out.println(localDate);

        MonthDay monthDay = MonthDay.from(localDate);
        System.out.println(monthDay);
    }

    @Test
    void testGet() {
        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println(year.getValue());
        System.out.println(yearMonth.getYear());
        System.out.println(yearMonth.getMonth());
        System.out.println(monthDay.getDayOfMonth());
    }
}
