package java18_spring_dasar.lesson09_choosing_dependency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Memilih Dependency
 * <p>
 * - Kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan
 * - Saat terdapat duplicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary
 * - Namun kita juga bisa memilih secara manual jika memang kita inginkan
 * - Kita bisa menggunakan annotation @Qualifier(value=”namaBean”) pada parameter di method nya
 */
public class ChoosingDependencyTest {

    @Test
    void choosingDependency() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo = context.getBean("fooSecond", Foo.class);
        Bar bar = context.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
