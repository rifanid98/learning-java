package java18_spring_dasar.lesson07_change_bean_name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Mengubah Nama Bean
 * <p>
 * - Secara default, nama bean diambil dari nama method
 * - Namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean
 * - Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean nya berbeda, dan di Spring, \
 * nama bean itu unik, tidak boleh sama
 * - Jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean
 */
public class ChangeBeanNameTest {

    @Test
    void changeNameBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo = context.getBean(Foo.class);
        Foo foo1 = context.getBean("fooFirst", Foo.class);
        Foo foo2 = context.getBean("fooSecond", Foo.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertSame(foo, foo1);
    }
}
