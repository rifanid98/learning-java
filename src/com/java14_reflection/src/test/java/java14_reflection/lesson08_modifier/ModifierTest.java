package java14_reflection.lesson08_modifier;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

/**
 * Modifier
 *
 * - Modifier merupakan representasi dari Java Modifier, seperti misal private, protected, public, abstract, dan lain-lain
 * - Modifier di Java Reflection direpresentasikan oleh number int, dan untuk mempermudah, kita bisa menggunakan class
 *   Modifier untuk mengecek jenis modifier nya
 * - Untuk mendapatkan data modifier, kita bisa menggunakan getModifiers(), entah itu di class, method, field, parameter,
 *   constructor, dan lain-lain
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Modifier.html
 */
public class ModifierTest {

    @Test
    void modifier() {
        Class<Person> personClass = Person.class;

        System.out.println(Modifier.isPublic(personClass.getModifiers()));
        System.out.println(Modifier.isFinal(personClass.getModifiers()));
        System.out.println(Modifier.isStatic(personClass.getModifiers()));
    }
}
