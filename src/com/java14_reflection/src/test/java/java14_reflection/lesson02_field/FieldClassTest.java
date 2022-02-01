package java14_reflection.lesson02_field;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * Field
 *
 * - Field merupakan representasi dari Java Field yang terdapat di dalam Java Class
 * - Untuk mendapatkan public Field, kita bisa menggunakan method getFields()
 * - Atau jika ingin mendapatkan semua field dengan semua visibility, kita bisa menggunakan method getDeclaredFields()
 * - Atau kita juga bisa mendapatkan Field berdasarkan nama field nya menggunakan method  getField(name) atau
 *   getDeclaredField(name)
 * - Field sama seperti Class<T>, memiliki banyak sekali method yang bisa kita gunakan untuk melihat detail dari Field
 *   tersebut, seperti tipe data, nama field, annotation, dan lain-lain
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Field.html
 */
public class FieldClassTest {

    @Test
    void field() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    /**
     * Mengambil atau Mengubah Field Object
     *
     * - Field memiliki kemampuan untuk mengambil atau mengubah field dari object yang ada
     * - Misal kita sudah membuat Field, lalu kita memiliki object person1, lalu kita ingin mengambil nilai Field
     *   tersebut atau mengubahnya, kita bisa menggunakan method setXxx() atau getXxx() pada Field
     */
    @Test
    void getFieldObject() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Adnin", "Rifandi");

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Object firstNameValue = firstName.get(person);
        System.out.println(firstNameValue);
    }

    @Test
    void changeFieldObject() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Adnin", "Rifandi");

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        firstName.set(person, "Joko");
        System.out.println(person.getFirstName());
    }
}
