package java18_spring_dasar.lesson05_duplicate_bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Duplicate Bean
 * <p>
 * - Di Spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama
 * - Namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean
 * yang berbeda
 * - Selain itu, saat kita mengakses bean nya, kita wajib menyebutkan nama bean nya, karena jika tidak, Spring akan
 * bingung harus mengakses bean yang mana
 */
public class DuplicateBeanTest {

    @Test
    void duplicateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
