package java17_lombok.lesson02_constructor;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Constructor
 * <p>
 * - Lombok juga bisa digunakan untuk membuat constructor secara otomatis
 * - @NoArgsConstructor digunakan untuk membuat constructor tanpa parameter
 * - @AllArgsConstructor digunakan untuk membuat constructor dengan semua parameter yang diambil dari field nya,
 * urutannya sesuai dengan urutan field nya
 */
public class ConstructorTest {

    @Test
    void constructor() {
        // @NoArgsConstructor
        Customer customer1 = new Customer();
        customer1.setId("100");
        customer1.setName("Adnin");

        // @AllArgsConstructor
        Customer customer2 = new Customer("200", "Rifandi");

        System.out.println(customer1);
        System.out.println(customer2);
    }

    /**
     * Static Method
     *
     * - Beberapa Class kadang ada yang menggunakan static method untuk membuat objectnya, contohnya Calendar, biasanya
     *   kita gunakan Calendar.getInstance()
     * - Lombok juga bisa digunakan untuk membuat object dengan static object, kita bisa gunakan annotation yang sama,
     *   namun kita bisa tambahkan method() staticName pada annotation nya
     * - Secara otomatis constructornya akan menjadi private, sehingga dipaksa untuk menggunakan static method ketika
     *   membuat object nya
     */
    @Test
    void staticMethod() {
        Login login1 = Login.createEmpty();
        Login login2 = Login.create("adnin", "password", false);

        System.out.println(login1);
        System.out.println(login2);
    }

    /**
     * Required Args Constructor
     *
     * - Saat kita menggunakan @NoArgsConstructor, maka akan dibuatkan constructor tanpa parameter, jika menggunakan
     *   @AllArgsConstructor, maka akan dibuatkan constructor untuk semua parameter
     * - Kadang-kadang kita hanya ingin membuat constructor untuk parameter yang memang wajib saja.
     * - Pada kasus ini, kita bisa menggunakan @RequiredArgsConstructor
     * - Secara otomatis Lombok hanya akan membuat constructor dengan parameter untuk field yang final
     */
    @Test
    void requiredArgsConstructor() {
        Merchant merchant = new Merchant(UUID.randomUUID().toString());
        System.out.println(merchant);
    }
}
