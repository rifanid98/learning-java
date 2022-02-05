package java17_lombok.lesson06_builder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder
 * <p>
 * - Saat membuat object yang kompleks, kadang agak menyulitkan jika harus selalu dibuat menggunakan constructor atau
 * menggunakan setter method
 * - Lombok memiliki fitur untuk melakukan auto generate class Builder untuk membuat object yang kompleks
 * - Dengan ini, pembuatan object akan lebih mudah menggunakan class Builder nya
 * - Caranya, kita cukup gunakan @Builder pada class tersebut
 * - Lombok akan secara otomatis membuat static method builder() untuk membuat builder objectnya, dan build() untuk
 * membuat object nya
 */
public class BuilderTest {

    @Test
    void createViaConstructor() {
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("learning");
        hobbies.add("coding");
        hobbies.add("gaming");

        Person person = new Person();
        person.setId("Id");
        person.setName("Name");
        person.setAge(23);
        person.setHobbies(hobbies);
        System.out.println(person);
    }

    @Test
    void createViaBuilder() {
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("learning");
        hobbies.add("coding");
        hobbies.add("gaming");

        Person person = Person.builder()
                .id("id")
                .name("name")
                .age(23)
                .hobbies(hobbies)
                .build();
        System.out.println(person);
    }

    /**
     * Singular
     *
     * - Saat membuat builder, secara default kita harus menggunakan object yang diperlukan secara langsung, misal
     *   sebelumnya ada field List<String> hobbies, maka kita wajib menambahkan langsung object List nya
     * - Lombok memiliki fitur @Singular, yang bisa digunakan sebagai helper, sehingga kita tidak perlu langsung membuat
     *   List nya
     * - Lombok akan membuat builder method untuk menambah data ke Collection (List, Set atau Map) nya satu per satu
     */
    @Test
    void singular() {
        PersonSingular person = PersonSingular.builder()
                .id("id")
                .name("name")
                .age(23)
                .hobby("learning")
                .hobby("coding")
                .hobby("gaming")
                // .clearHobbies() // clear hobbies
                .build();
        System.out.println(person);
    }
}
