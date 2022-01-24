package java11_internationalization.lesson05_currency;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

/**
 * I18N di Currency
 *
 * - Java juga mendukung I18N untuk mata uang atau currency
 * - Ada 2 class yang bisa kita gunakan untuk melakukan I18N di Java, yaitu class Currency dan class NumberFormat
 *
 * Currency Class
 *
 * - Currency class adalah implementasi standard dari ISO 4217 currency codes
 * - https://www.iso.org/iso-4217-currency-codes.html
 * - Dengan menggunakan class ini, kita bisa mengetahui nama mata uang, kode mata uang sampai simbol yang digunakan
 * - Untuk membuat object Currency, kita wajib menggunakan Locale yang memiliki negara, karena memang mata uang tergantung
 *   dari negaranya, bukan bahasanya
 * - Constructor Currency class adalah private, jadi untuk membuat Currency, kita harus menggunakan static method getInstance()
 *
 * Currency di NumberFormat
 *
 * - Currency class hanya digunakan untuk mendapatkan data nama mata uang, satuan, dan simbol, bagaimana jika kita ingin
 *   melakukan format number dalam bentuk mata uang?
 * - Jika dalam kasus ini, lebih baik menggunakan NumberFormat
 * - NumberFormat juga tidak hanya bisa digunakan untuk format dan parsing number, tapi juga number dalam bentuk currency
 * - Untuk membuat NumberFormat yang mendukung currency, kita bisa gunakan static method getCurrencyInstance()
 */
public class CurrencyTest {

    @Test
    void testCurrency() {
        Locale indonesianLocale = new Locale("id", "ID");
        Currency currency = Currency.getInstance(indonesianLocale);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(indonesianLocale));
    }

    @Test
    void testCurrencyUSA() {
        Locale usaLocale = new Locale("en", "US");
        Currency currency = Currency.getInstance(usaLocale);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(usaLocale));
    }

    @Test
    void testCurrencyJapan() {
        Locale japanLocale = new Locale("jp", "JP");
        Currency currency = Currency.getInstance(japanLocale);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(japanLocale));
    }

    @Test
    void testNumberFormatCurrencyIndonesia() {
        Locale indonesianLocale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        String format = numberFormat.format(1000000);
        System.out.println(format);
    }

    @Test
    void testNumberFormatCurrencyIndonesiaParse() {
        Locale indonesianLocale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        try {
            Double parse = numberFormat.parse("Rp1.000.000,00").doubleValue();
            System.out.println(parse);
        } catch (ParseException e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
