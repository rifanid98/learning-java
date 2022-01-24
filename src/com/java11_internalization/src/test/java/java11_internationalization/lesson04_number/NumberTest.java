package java11_internationalization.lesson04_number;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * I18N di Number
 *
 * - Apakah perlu I18N di number?
 * - Yup perlu, karena kadang beda bahasa beda format penulisan number nya.
 * - Contoh, di Indonesia menggunakan . (titik) sebagai pemisah ribuan, dan , (koma) untuk pemisah bilangan pecahan,
 *   sedangkan di Amerika, itu terbalik
 *
 * NumberFormat Class
 *
 * - Untuk melakukan I18N di Java, kita bisa menggunakan class NumberFormat
 * - NumberFormat adalah abstract class, untuk membuat object NumberFormat, kita bisa menggunakan static method
 *   getInstance() milik class NumberFormat
 */
public class NumberTest {

    @Test
    void testNumberFormat() {
        var numberFormat = NumberFormat.getInstance();
        var format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    @Test
    void testNumberFormatIndonesia() {
        var indonesianLocale = new Locale("id", "ID");
        var numberFormat = NumberFormat.getInstance(indonesianLocale);
        var format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    @Test
    void testNumberFormatParse() {
        var indonesianLocale = new Locale("id", "ID");
        var numberFormat = NumberFormat.getInstance(indonesianLocale);

        try {
            var number = numberFormat.parse("10.000.000,255").doubleValue();
            System.out.println(number);
        } catch (ParseException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
