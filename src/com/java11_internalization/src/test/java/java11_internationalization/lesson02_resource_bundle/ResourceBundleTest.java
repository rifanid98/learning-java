package java11_internationalization.lesson02_resource_bundle;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Resource Bundle
 *
 * - ResourceBundle adalah class yang digunakan sebagai bundle yang berisikan data yang bisa berubah sesuai dengan Locale
 *   yang dipilih.
 * - ResourceBundle cocok digunakan untuk menyimpan data I18N, dimana semua data akan disimpan dalam sebuah properties
 *   file
 *
 * Properties File
 *
 * - Saat kita menggunakan ResourceBundle, kita perlu membuat properties file di dalam resources sebagai tempat untuk
 *   ResourceBundle melakukan lookup data
 * - Misal kita membuat file properties dengan nama message.properties di dalam resources
 *
 * I18N di ResourceBundle
 *
 * - Kode sebelumnya kita hanya menggunakan ResourceBundle sebagai object untuk mengambil data dari properties file,
 *   kalo seperti ini tidak ada bedanya dengan class Properties
 * - Yang membedakan, dalam ResourceBundle, kita bisa melakukan I18N
 * - Namun untuk melakukan itu, kita perlu menyediakan properties file sesuai dengan Locale nya
 * - Misal jika kita ingin mendukung bahasa in dan negara ID, maka kita perlu membuat message_in_ID.properties.
 * - File nya butuh diawali dengan message karena sebelumnya kita menggunakan nama file message.properties
 *
 * Jika Tidak ada Properties untuk Locale
 *
 * - Apa yang terjadi jika ada Locale yang tidak tersedia dalam file properties nya?
 * - Misal kita akan menggunakan Locale en_US, sedangkan tidak ada file message_en_US.properties nya?
 * - Jika itu terjadi, secara default ResourceBundle akan menggunakan message.properties
 *
 * Amankah Membuat ResourceBundle Terus?
 *
 * - Cara membuat ResourceBundle menggunakan static method getBundle()
 * - Di dalam implementasi getBundle() telah diimplementasikan caching, artinya jika kita mengambil resource yang sama
 *   dengan locale yang sama, tidak akan dibuat ulang, melainkan akan menggunakan ResourceBundle yang sudah tersedia
 * - Hal ini menjadi aman jika kita selalu membuat ResourceBundle terus menerus
 */
public class ResourceBundleTest {

    @Test
    void testResourceBundle() {
        var resourceBundle = ResourceBundle.getBundle("message");
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    @Test
    void testResourceBundleIndonesiaLocale() {
        Locale indonesianLocale = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", indonesianLocale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    @Test
    void testResourceBundleNotFoundLocale() {
        Locale notFoundLocale = new Locale("notFound", "NOT_FOUND");
        var resourceBundle = ResourceBundle.getBundle("message", notFoundLocale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }
}
