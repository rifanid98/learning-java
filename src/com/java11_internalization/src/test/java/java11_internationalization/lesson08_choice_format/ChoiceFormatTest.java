package java11_internationalization.lesson08_choice_format;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Choice Format
 *
 * - ChoiceFormat class adalah class yang digunakan untuk menyematkan data dengan range number, biasanya ini digunakan
 *   untuk kata plurals, misal jika 1 namanya file, jika banyak namanya files
 * - Pembuatan pattern untuk ChoiceFormat sangat sederhana, cukup gunakan number#value atau number<value, dan urutannya
 *   harus dari kecil ke besar, dan dipisahkan menggunakan tanda | (pagar), misal :
 * - -1#negatif | 0#kosong | 1#satu | 1<banyak
 *
 * ChoiceFormat di MessageFormat
 *
 * - Seperti yang sudah kita bahas di MessageFormat
 * - ChoiceFormat juga didukung di MessageFormat, kita cukup gunakan type
 */
public class ChoiceFormatTest {

    @Test
    void testChoiceFormat() {
        var pattern = "-1#negatif|0#kosong|1#satu|1<banyak";
        var choiceFormat = new ChoiceFormat(pattern);
        System.out.println(choiceFormat.format(-1));
        System.out.println(choiceFormat.format(0));
        System.out.println(choiceFormat.format(1));
        System.out.println(choiceFormat.format(2));
    }

    @Test
    void testChoiceFormatMessageFormat() {
        var locale = new Locale("id", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);
        var pattern = resourceBundle.getString("balance");
        var messageFormat = new MessageFormat(pattern, locale);

        System.out.println(messageFormat.format(new Object[]{-1000000}));
        System.out.println(messageFormat.format(new Object[]{0}));
        System.out.println(messageFormat.format(new Object[]{1000000}));
    }
}
