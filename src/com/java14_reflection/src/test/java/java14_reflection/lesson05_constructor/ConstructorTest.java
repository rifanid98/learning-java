package java14_reflection.lesson05_constructor;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * Constructor<T>
 * <p>
 * - Constructor<T> merupakan representasi dari Java Constructor di Java Class
 * - Constructor<T> ini mirip dengan Method, dimana dia memiliki Parameter
 * - Untuk membuat Constructor kita mendapatkannya melalui Class<T>
 * - Constructor<T> merupakan tipe data generic, mengikuti tipe data generic dari Class<T> nya
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Constructor.html
 */
public class ConstructorTest {

    @Test
    void constructor() {
        Class<Person> personClass = Person.class;

        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            for (Parameter parameter : constructor.getParameters()) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType());
            }
        }
    }

    /**
     * Membuat Object dengan Constructor
     * <p>
     * - Kita sudah tahu bahwa Constructor merupakan method yang dieksekusi ketika sebuah Object pertama kali dibuat
     * - Dengan menggunakan Constructor, kita juga bisa membuat object baru
     * - Caranya  dengan menggunakan method newInstance(parameter...)
     */
    @Test
    void createObjectWithConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructorEmpty = personClass.getConstructor();
        Constructor<Person> constructorParameters = personClass.getConstructor(String.class, String.class);

        Person person1 = constructorEmpty.newInstance();
        Person person2 = constructorParameters.newInstance("Adnin", "Rifandi");

        System.out.println(person1);
        System.out.println(person2);
    }
}
