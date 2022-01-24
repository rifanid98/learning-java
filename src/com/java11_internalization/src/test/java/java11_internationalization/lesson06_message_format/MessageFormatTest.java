package java11_internationalization.lesson06_message_format;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Message Format
 *
 * - Ketika melakukan I18N, kadang kita membutuhkan data yang bentuknya dinamis, sesuai dengan parameter, misal kita
 *   butuh String Hi {nama}, Selamat Datang di {aplikasi}
 * - Jika kita menggunakan Resource Bundle, hal tersebut tidak bisa dilakukan secara otomatis, kita perlu melakukannya
 *   secara manual, dengan cara menggabungkan beberapa String
 * - Untungnya di Java terdapat class bernama MessageFormat
 * - MessageFormat class ini digunakan untuk melakukan substitusi data parameter, namun data string awalnya perlu
 *   ditambahkan penanda parameter
 *
 * Parameter di MessageFormat
 *
 * - Penggunakann parameter di MessageFormat, menggunakan kurung kurawal buka, diikuti dengan index (dimulai dari 0) dan
 *   diakhiri dengan kurung kurawal tutup, misal :
 * - Hi {0}, Selamat Datang di {1}
 * - Jika kita menggunakan nomor index yang sama, artinya data akan menggunakan parameter yang sama, misal :
 * - Hi {0}, Anda bisa mencari data Anda dengan mengetik “{0}” di pencarian.
 *
 * Integrasi Dengan ResourceBundle
 *
 * - Sebenarnya sekilas kita perhatikan jika MessageFormat itu tidak ada hubungannya dengan I18N
 * - Namun, kita juga bisa mengkombinasikan dengan ResourceBundle, dan menyimpan pattern nya di dalam ResourceBundle
 *   properties file
 * - Dengan demikian, MessageFormat seakan-akan memiliki kemampuan I18N
 */
public class MessageFormatTest {

    @Test
    void testMessageFormat() {
        String pattern = "Hi {0}, Anda bisa mencari data Anda dengan mengetik `{0}` di pencarian";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String format = messageFormat.format(new Object[]{"Adnin"});
        System.out.println(format);
    }

    @Test
    void testMessageFormatResourceBundle() {
        Locale indonesianLocale = new Locale("id", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", indonesianLocale);
        String pattern = resourceBundle.getString("welcome.message");
        MessageFormat messageFormat = new MessageFormat(pattern);
        String format = messageFormat.format(new Object[]{"Adnin", "Indonesia"});
        System.out.println(format);
    }
}
