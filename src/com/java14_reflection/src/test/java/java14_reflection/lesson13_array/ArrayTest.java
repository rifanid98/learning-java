package java14_reflection.lesson13_array;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

/**
 * Array
 *
 * - Sama seperti tipe data yang lainnya, Array pun di representasikan dalam bentuk Class<T> di Java Reflection
 * - Untuk membuat Class<T> Array, kita bisa gunakan .class setelah Array nya, misal String[].class, int[].class, dan
 *   sebagainya
 * - Bahkan kita bisa buat array multi dimensi, misal String[][].class
 * - Yang membedakan dengan Class<T> lainnya, pada Array, method isArray() nya akan bernilai true
 */
public class ArrayTest {

    @Test
    void array() {
        Class<String[]> stringArrayClass = String[].class;
        Class<int[][]> intArrayClass = int[][].class;

        System.out.println(stringArrayClass.isArray());
        System.out.println(intArrayClass.isArray());
    }

    /**
     * Array Member
     *
     * - Sedikit berbeda dengan tipe data seperti Class, Interface, Enum, pada Array tidak memiliki Class Member,
     *   seperti Field, Method dan Constructor
     * - Sehingga jika pada Class<T>, kita coba memanggil getFields(), getMethods(), getConstructors(), maka hasilnya
     *   adalah kosong
     */
    @Test
    void arrayMember() {
        Class<String[]> stringArrayClass = String[].class;

        System.out.println(stringArrayClass.getDeclaredFields());
        System.out.println(stringArrayClass.getDeclaredMethods());
        System.out.println(stringArrayClass.getDeclaredConstructors());
    }

    /**
     * java.lang.reflect.Array
     *
     * - Lantas bagaimana jika kita ingin mengakses data array, membuat array dan lain-lain, jika pada Class<T>, semua
     *   class member nya tidak tersedia di Array?
     * - Untungnya terdapat class java.lang.reflect.Array , yang bisa kita gunakan untuk membantu menggunakan Class<T>
     *   dengan tipe Array
     * - Ada banyak method yang bisa kita gunakan, dari membuat array, mengakses datanya sampai mengubah data array
     * - Dan dari Class<T> Array, jika kita ingin tahu tipe data array nya, kita bisa gunakan method getComponentType()
     * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Array.html
     */
    @Test
    void javalangreflectArray() {
        Class<String[]> stringArrayClass = String[].class;

        Object array = Array.newInstance(stringArrayClass.getComponentType(), 10);

        Array.set(array, 0, "Adnin");
        Array.set(array, 1, "Rifandi");

        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
    }
}
