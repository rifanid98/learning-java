package java17_lombok.lesson01_getter_setter;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

/**
 * Getter dan Setter
 *
 * - Lombok bisa kita gunakan untuk membuat Getter dan Setter method secara otomatis dengan menggunakan annotation
 *   @Getter dan @Setter
 * - Jika ditempatkan pada field, secara otomatis akan membuat getter atau setter untuk field tersebut
 * - Jika ditempatkan pada class, semua field yang tidak static akan otomatis dibuatkan getter atau setter nya
 */
public class GetterSetterTest {

    @Test
    void getterSetter() {
        Customer customer = new Customer();
        customer.setId("100");
        customer.setName("Adnin");

        System.out.println(customer);
    }

    /**
     * Access Level
     *
     * - Saat menggunakan @Getter dan @Setter, secara default method getter dan setter nya akan dibuat public
     * - Namun jika kita ingin ubah, kita juga bisa ubah visibility nya menggunakan method value() di @Gettter atau
     *   @Setter
     */
    @Test
    void accessLevel() {
        Login login = new Login();
        login.setUsername("Username");
        login.setPassword("Password");
        //login.setIsAdmin(true) // private

        System.out.println(login);
    }
}
