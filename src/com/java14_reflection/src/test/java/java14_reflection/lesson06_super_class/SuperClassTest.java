package java14_reflection.lesson06_super_class;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

/**
 * Super Class
 * <p>
 * - Dengan menggunakan Java Reflection, kita  juga bisa mengetahui Super Class dari sebuah Java Class
 * - Terdapat method getSuperclass() di Class<T> untuk mendapatkan Super Class nya
 * - Perlu diingat, bahwa saat kita membuat class, jika kita tidak menambahkan super class, secara otomatis super class
 * nya adalah class java.lang.Object
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Class.html#getSuperclass()
 */
public class SuperClassTest {

    @Test
    void superClass() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass); // Person

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass); // Object

        Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass); // null
    }
}
