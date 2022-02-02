package java14_reflection.lesson12_primitive_type;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Primitive Type
 *
 * - Apa yang terjadi jika kita memiliki field atau parameter atau method yang mengembalikan nilai primitive type?
 *   Seperti int, long, boolean, dan lain-lain
 * - Data tersebut pun, pada Java Reflection tetap direpresentasikan dalam Class<T>
 * - Untuk membuat Class<T> primitive, kita langsung gunakan .class setelah tipe data primitive tersebut, namun Java
 *   akan secara otomatis mengkonversi nya menjadi tipe data non primitive, misal int menjadi Integer, boolean menjadi Boolean, dan lain-lain
 * - Namun yang membedakan adalah, method isPrimitive() akan bernilai true untuk tipe data primitive
 */
public class PrimitiveTypeTest {

    @Test
    void primitiveType() {
        Class<Integer> integerClass = int.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass.isPrimitive());
        System.out.println(longClass.isPrimitive());
        System.out.println(booleanClass.isPrimitive());
    }

    /**
     * Mengambil Data Primitive Type
     *
     * - Khusus tipe data primitive, ketika ingin mengambil data di Field, kita bisa gunakan method getXxx() sesuai
     *   dengan tipe data nya, misal getInt(), getBoolean() dan lain-lain
     * - Namun ketika mengambil method dengan parameter, kita bisa gunakan representasi tipe data object nya, misal
     *   untuk int gunakan Integer, long gunakan Long, dan lain-lain
     */
    @Test
    void getDataPrimitiveType() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");
        System.out.println(age.getType().isPrimitive());
    }

    @Test
    void getFieldPrimitiveType() throws IllegalAccessException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");

        Person person = new Person();
        person.setAge(23);

        age.setAccessible(true);
        System.out.println(age.getInt(person));
    }

    @Test
    void invokeMethodPrimitiveType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person();
        setAge.invoke(person, 24);

        System.out.println(person.getAge());
    }
}
