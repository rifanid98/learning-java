package java14_reflection.lesson16_record;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

/**
 * Record
 *
 * - Di Java versi 16, fitur Java Record sudah stabil, dan kita juga bisa menggunakan Java Reflection
 * - Record di Java Reflection tetap direpresentasikan dengan Class<T>
 * - Hanya saja method isRecord() akan mengembalikan nilai true, selain itu untuk mendapatkan detail Record, kita bisa
 *   gunakan getRecordComponents()
 * - Dan jangan lupa, saat kita membuat Record, parent class nya bukanlah  Object, melainkan java.lang.Record
 * - https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/reflect/RecordComponent.html
 */
public class RecordTest {

    @Test
    void record() {
        Class<Product> productClass = Product.class;
        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test
    void modifyRecordComponent() throws InvocationTargetException, IllegalAccessException {
        Product product = new Product("1", "iPhone", 20000000L);

        Class<Product> productClass = Product.class;
        RecordComponent component = Arrays.stream(productClass.getRecordComponents())
                .filter(recordComponent -> recordComponent.getName().equals("id"))
                .findFirst().get();
        Method method = component.getAccessor();
        System.out.println(method.invoke(product));
    }
}
