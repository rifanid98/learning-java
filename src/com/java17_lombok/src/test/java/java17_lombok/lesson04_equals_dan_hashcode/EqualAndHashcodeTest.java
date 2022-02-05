package java17_lombok.lesson04_equals_dan_hashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Equals dan HashCode
 *
 * - Lombok juga bisa digunakan untuk membuat method equals dan hashCode secara otomatis
 * - Seperti yang pernah dijelaskan di kelas Java OOP, kedua method ini akan selalu diimplementasikan berbarengan
 * - Untuk membuat Equals dan HashCode secara otomatis, kita bisa gunakan annotation @EqualsAndHashCode
 */
public class EqualAndHashcodeTest {

    @Test
    void equalsAndHashcode() {
        Customer customer1 = new Customer("ID", "NAME");
        Customer customer2 = new Customer("ID", "NAME");

        Assertions.assertEquals(customer1, customer2);
        Assertions.assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    /**
     * Exclude Field
     *
     * - Saat membuat equals() dan hashCode() method, Lombok akan selalu menyamakan field mana yang dibandingkan
     * - Secara default, Lombok akan menggunakan semua field yang ada di class tersebut
     * - Jika kita tidak ingin menggunakan salah satu field, kita bisa gunakan exclude() method di annotation nya
     */
    @Test
    void excludeField() {
        CustomerExcludeNameField customer1 = new CustomerExcludeNameField("ID", "NAME1");
        CustomerExcludeNameField customer2 = new CustomerExcludeNameField("ID", "NAME2");

        Assertions.assertEquals(customer1, customer2);
        Assertions.assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    /**
     * Super Class
     *
     * - Secara default, ketika membuat equals() dan hashCode() method, Lombok tidak akan memanggil super class method
     *   nya
     * - Jika kita ingin Lombok memanggil juga super class method nya, kita perlu mengubah method callSuper() menjadi
     *   true di annotation nya, default nya adalah false
     */
    @Test
    void superClass() {
    }
}
