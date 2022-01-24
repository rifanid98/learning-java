package java11_internationalization.lesson07_message_format_type;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Message Format Type
 *
 * - Materi sebelumnya kita sudah membahas tentang MessageFormat untuk melakukan substitusi data.
 * - Bagaimana jika datanya bentuknya adalah Number atau Date?
 * - Sebelumnya kita sudah tahu, bahwa kita bisa melakukan I18N di Number dan Date, apakah ini juga bisa kita lakukan di
 *   MessageFormat?
 * - Jawabanya adalah iya, kita bisa lakukan itu, namun perlu ada beberapa perubahan
 */
public class MessageFormatTypeTest {

    @Test
    void testMessageFormatType() {
        var indonesianLocale = new Locale("id", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", indonesianLocale);

        var pattern = resourceBundle.getString("status");

        var messageFormat = new MessageFormat(pattern, indonesianLocale);
        var format = messageFormat.format(new Object[]{"Adnin", new Date(), 1000000});

        System.out.println(format);
    }

    @Test
    void testMessageFormatTypeUSA() {
        var usaLocale = new Locale("en", "US");
        var resourceBundle = ResourceBundle.getBundle("message", usaLocale);

        var pattern = resourceBundle.getString("status");

        var messageFormat = new MessageFormat(pattern, usaLocale);
        var format = messageFormat.format(new Object[]{"Adnin", new Date(), 1000000});

        System.out.println(format);
    }
}
