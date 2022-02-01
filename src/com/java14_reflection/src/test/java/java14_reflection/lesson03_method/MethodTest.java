package java14_reflection.lesson03_method;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Method
 * <p>
 * - Selain Field, kita juga bisa mendapatkan Method yang tersedia di Class<T>
 * - Cara mendapatkannya pun sama seperti Field, kita bisa menggunakan method getMethods(), getDeclaredMethods(),
 * getMethod(name) dan getDeclaredMethod(name)
 * - Method pun banyak sekali method yang bisa kita gunakan untuk mendapatkan informasi seperti return value, name,
 * annotation, parameter dan lain-lain
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Method.html
 */
public class MethodTest {

    @Test
    void method() {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("============");
        }
    }

    /**
     * Memanggil Method Object
     *
     * - Method bisa digunakan untuk memanggil method pada sebuah object
     * - Hampir mirip dengan Field yang bisa digunakan untuk mengambil atau mengubah field didalam object
     * - Untuk memanggil method object, kita bisa menggunakan method invoke(object, parameters...)
     */
    @Test
    void callObjectMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("Adnin", "Rifandi");

        Class<Person> personClass = Person.class;
        Method getFirstName = personClass.getDeclaredMethod("getFirstName");

        Object response = getFirstName.invoke(person);
        System.out.println(response);
    }
}
