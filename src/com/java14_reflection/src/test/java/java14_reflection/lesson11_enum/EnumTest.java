package java14_reflection.lesson11_enum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Enum
 *
 * - Enum di Java Reflection, sama seperti Interface, direpresentasikan dengan Class<T>, hal ini dikarenakan, pada Enum
 *   juga kita bisa menambahkan field, method dan constructor
 * - Yang membedakan adalah, method  isEnum() nya bernilai true
 * - Dan untuk mendapatkan semua nilai Enum, kita bisa menggunakan method getEnumConstants()
 * - Selain itu super class Enum adalah java.lang.Enum
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Enum.html
 */
public class EnumTest {

    @Test
    void testEnum() {
        Class<Gender> genderClass = Gender.class;
        System.out.println(genderClass.getName());
        System.out.println(genderClass.isEnum());
        System.out.println(genderClass.getSuperclass());
        System.out.println(Arrays.toString(genderClass.getEnumConstants()));
    }
}
