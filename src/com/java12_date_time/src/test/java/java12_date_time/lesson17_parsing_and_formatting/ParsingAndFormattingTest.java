package java12_date_time.lesson17_parsing_and_formatting;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Parsing dan Formatting
 *
 * - Sebelumnya di awal-awal kita sering sekali menggunakan method parse untuk melakukan parsing data String menjadi
 *   objek Temporal
 * - Sebenarnya proses parsing dan formatting tersebut dilakukan oleh class java.time.format.DateTimeFormatter
 *
 * Pattern
 *
 * - Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java
 *   Internationalization
 * - Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 */
public class ParsingAndFormattingTest {

    /**
     * Parsing
     *
     * - Sebelumnya kita sudah bahas tentang default pattern untuk parsing semua tipe objek temporal
     * - Jika kita ingin mengubah format pattern nya, kita bisa menggunakan DateTimeFormatter pada saat melakukan parsing,
     *   misal :
     * - LocalDate.parse(“yyyy MM hh”, dateTimeFormatter)
     */
    @Test
    void testParsing() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2020 10 25", formatter);
        System.out.println(localDate);
    }

    /**
     * Formatting
     *
     * - Untuk formatting juga kita bisa menggunakan DateTimeFormatter
     * - Untuk melakukan formatting, kita bisa menggunakan method format(DateTimeFormatter) milik objek temporal
     */
    @Test
    void testFormatting() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2020 10 25", formatter);
        String format = localDate.format(formatter);
        System.out.println(format);
    }

    /**
     * DefaultFormatter
     *
     * - Selain kita bisa membuat formatter sendiri menggunakan pattern
     * - Sudah disediakan juga formatter default, sehingga jika kita ingin menggunakan formatter misal yang sudah
     *   standar internasional, kita tidak perlu membuat ulang menggunakan pattern
     */
    @Test
    void testDefaultFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2020 10 25", formatter);
        String format = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
    }

    /**
     * Internationalization
     *
     * - DateTimeFormatter juga mendukung internationalization
     * - Caranya saat membuat formatter, kita perlu menambahkan Locale
     */
    @Test
    void testInternationalization() {
        Locale locale = new Locale("id", "ID");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", locale);
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(formatter);
        System.out.println(format);
    }
}
