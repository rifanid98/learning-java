package java11_internationalization.lesson03_date_time;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * I18N di Date dan Time
 *
 * - I18N di tipe data String mungkin sederhana, bagaimana jika tipe data Date atau Waktu?
 * - Di Java kita tahu bahwa tipe data Date dan Time direpresentasikan dalam class Date
 * - Bagaimana misal jika kita ingin menampilkan tanggal dalam bahasa Indonesia, bahasa Inggris, atau yang lainnya?
 * - Di Java, I18N di Date sudah disediakan menggunakan DateFormatter
 *
 * DateFormat Class
 *
 * - DateFormat merupakan class yang bisa kita gunakan untuk melakukan parsing dari String ke Date, atau format dari
 *   Date ke String
 * - DateFormat mendukung I18N jika misal kita ingin melakukan format dan parse, sehingga bisa menerima hari dengan data
 *   Sunday, Monday atau Minggu, Senin
 * - DateFormat adalah abstract class, salah satu implementasinya adalah class SimpleDateFormat
 */
public class DateTimeTest {

    @Test
    void testDateFormat() {
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatIndonesianLocale() {
        var indonesianLocale = new Locale("id", "ID");
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern, indonesianLocale);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatJapanLocale() {
        var japanLocale = new Locale("ja", "JP");
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern, japanLocale);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatParse() {
        var indonesianLocale = new Locale("id", "ID");
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern, indonesianLocale);

        try {
            var date = dateFormat.parse("Senin 24 Januari 2022");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Test
    void testDateFormatParseJapan() {
        var japanLocale = new Locale("ja", "JP");
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern, japanLocale);

        try {
            var date = dateFormat.parse("月曜日 24 1月 2022");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
