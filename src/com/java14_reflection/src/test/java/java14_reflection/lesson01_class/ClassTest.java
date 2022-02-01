package java14_reflection.lesson01_class;

import org.junit.jupiter.api.Test;

/**
 * Class<T>
 * <p>
 * - java.lang.Class<T> merupakan representasi dari reflection untuk Java Class, Interface dan Enum
 * - Saat kita membuat Java Class, Interface atau Enum, kadang kita menambahkan field dan method
 * - Dengan kemampuan java.lang.Class, kita bisa membaca seluruh data member yang terdapat pada Java Class, Interface
 * atau Enum pada saat aplikasi nya berjalan
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Class.html
 * <p>
 * Membuat Class<T>
 * <p>
 * - Untuk membuat Class<T>, kita bisa melakukan beberapa cara
 * - Cara yang pertama adalah dengan  menggunakan kata kunci .class setelah nama Java Class, Interface atau Enum nya,
 * misal Person.class, Repository.class, atau Gender.class
 * - Atau kita juga bisa membuat Class<T> dari sebuah String, menggunakan static method
 * Class.forClass(“com.example.blabla.Person”)
 * - Atau kita juga bisa mengambil Class<T> dari object, dengan menggunakan method getClass()
 */
public class ClassTest {

    @Test
    void testClass() throws ClassNotFoundException {
        Class<Person> personClass1 = Person.class;
        Class<?> personClass2 = Class.forName("java14_reflection.lesson01_class.Person");
        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();

        System.out.println(personClass1);
        System.out.println(personClass2);
        System.out.println(personClass3);
    }

    /**
     * Class<T> Method
     *
     * - Class<T> memiliki banyak sekali method
     * - Seperti untuk mendapatkan method, fields, constructor, annotation, superclass, interfaces dan lain-lain
     * - Semua detail method nya bisa kita baca di Javadoc
     * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Class.html
     */
    @Test
    void classMethod() {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(personClass.getInterfaces());
        System.out.println(personClass.getDeclaredConstructors());
        System.out.println(personClass.getDeclaredMethods());
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
    }
}
