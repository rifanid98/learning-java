package java14_reflection.lesson04_parameter;

import java14_reflection.lesson01_class.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Parameter
 *
 * - Parameter merupakan representasi dari Java Parameter di Java Method
 * - Cara mendapatkan Parameter, kita bisa ambil dari Method, karena Parameter memang hanya ada di Method dan Constructor
 *   (yang akan kita bahas nanti)
 * - Parameter memiliki banyak sekali method, seperti untuk mendapatkan tipe data parameter, nama parameter, dan lain-lain
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/Parameter.html
 */
public class ParameterTest {

    @Test
    void parameter() {
        Class<Person> personClass = Person.class;

        for (Method method : personClass.getDeclaredMethods()) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType());
            }
            System.out.println("========");
        }
    }

    /**
     * Memanggil Method Object dengan Parameter
     *
     * - Sama seperti Method tanpa parameter
     * - Kita juga bisa memanggil Method yang memiliki parameter
     */
    @Test
    void invokeObjectMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Adnin", "Rifandi");
        setFirstName.invoke(person, "Sutanto");

        System.out.println(person.getFirstName());
    }
}
