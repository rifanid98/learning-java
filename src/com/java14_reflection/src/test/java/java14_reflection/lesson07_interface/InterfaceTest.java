package java14_reflection.lesson07_interface;

import org.junit.jupiter.api.Test;

/**
 * Interface
 *
 * - Sebelumnya kita hanya bahas tentang Class, bagaimana dengan Interface?
 * - Interface sebenarnya representasi di Java Reflection tetaplah Class<T>
 * - Yang membedakan adalah, pada Interface sudah pasti tidak memiliki Constructor dan juga tidak bisa
 * - Selain itu untuk mengetahui apakah Class<T> ini adalah Java Class atau Java Interface, kita  bisa menggunakan method
 *   isInterface()
 */
public class InterfaceTest {

    @Test
    void testInterface() {
        Class<Nameable> nameableClass = Nameable.class;
        System.out.println(nameableClass.isInterface());
        System.out.println(nameableClass.getName());
        System.out.println(nameableClass.getInterfaces());
        System.out.println(nameableClass.getSuperclass());
        System.out.println(nameableClass.getDeclaredFields());
        System.out.println(nameableClass.getDeclaredMethods());
        System.out.println(nameableClass.getDeclaredConstructors());
    }

    /**
     * Super Interface
     *
     * - Kita tahu bahwa Interface juga mendukung pewarisan, berbeda dengan class, saat kita melakukan implements
     *   Interface, bisa lebih dari satu interface, selain itu interface juga bisa extends Interface
     * - Pada kasus seperti ini, jika kita melihat semua super interface Class<T>, kita bisa menggunakan method
     *   getInterfaces()
     */
    @Test
    void superInterface() {
        Class<Person> personClass = Person.class;

        for (Class<?> anInterface : personClass.getInterfaces()) {
            System.out.println(anInterface.getName());
        }
    }
}
