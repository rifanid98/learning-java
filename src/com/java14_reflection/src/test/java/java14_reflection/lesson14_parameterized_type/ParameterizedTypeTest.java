package java14_reflection.lesson14_parameterized_type;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/**
 * Parameterized Type
 *
 * - Kita sudah hampir membahas semua jenis tipe Reflection di Java, namun di Java terdapat fitur yang bernama Generic
 *   Programming
 * - Bagaimana cara handle data generic di Java Reflection? misal List<String>, atau Map<String, String>
 * - Kita bisa menggunakan ParameterizedType untuk menangani hal ini
 * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/ParameterizedType.html
 */
public class ParameterizedTypeTest {

    @Test
    void parameterizedReturnType() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;

        Method getHobbies = personClass.getDeclaredMethod("getHobbies");

        Type returnType = getHobbies.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void parameterizedParameterType() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;

        Method setHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

        for (Type type : setHobbies.getGenericParameterTypes()) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println(parameterizedType.getRawType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }
    }

    @Test
    void parameterizedField() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Field hobbies = personClass.getDeclaredField("hobbies");
        Type type = hobbies.getGenericType();

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    /**
     * Type Variable
     *
     * - Sebelumnya kita buat generic dengan data asli, seperti String dan lain-lain, bagaimana jika kita ingin
     *   mengetahui tipe data generic tanpa implementasi data asli, misal kita ingin mempelajari class List<T>, Map<K, V>
     * - Parameter generic tersebut, dalam Java Reflection, direpresentasikan dalam class TypeVariable
     * - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/reflect/TypeVariable.html
     */
    @Test
    void typeVariable() {
        Class<Data> dataClass = Data.class;

        for (TypeVariable<Class<Data>> typeParameter : dataClass.getTypeParameters()) {
            System.out.println(typeParameter.getName());
            System.out.println(Arrays.toString(typeParameter.getBounds()));
        }
    }
}
