package java14_reflection.lesson10_annotation;

import org.junit.jupiter.api.Test;

/**
 * Annotation
 *
 * - Pada Kelas Java OOP kita sudah bahas tentang Annotation
 * - Sekarang kita bahas tentang mendapatkan informasi Annotation dengan menggunakan Reflection
 * - Annotation merupakan fitur yang sangat powerfull sekali di Java, banyak sekali framework menggunakan Annotation
 * - Annotation bisa ditempatkan dimanapun, di class, method, field, constructor, parameter, package dan lain-lain
 * - Setiap kita membuat Annotation, secara tidak langsung kita telah membuat turunan java.lang.annotation.Annotation
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/annotation/Annotation.html
 */
public class AnnotationTest {

    @Test
    void annotation() throws IllegalAccessException {
        Person person = new Person("Adnin", "");
        Validator.validateNotBlank(person);
    }
}
