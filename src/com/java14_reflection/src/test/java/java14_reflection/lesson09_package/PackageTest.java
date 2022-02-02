package java14_reflection.lesson09_package;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Package
 * <p>
 * - Package merupakan representasi dari Java Package
 * - Kita bisa mendapatkan Package dari Class<T> dengan menggunakan method getPackage()
 * - Terdapat banyak informasi di dalam Package yang bisa kita gunakan
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Package.html
 * <p>
 * package-info.lang
 * <p>
 * - Package di Java bisa kita tambahkan informasi tambahan
 * - Seperti javadoc dan annotation misalnya
 * - Caranya kita bisa membuat file package-info.lang di package yang kita inginkan
 */
public class PackageTest {

    @Test
    void testPackage() {
        Class<Person> personClass = Person.class;

        Package aPackage = personClass.getPackage();
        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
    }
}
