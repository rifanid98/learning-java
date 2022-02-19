package java18_spring_dasar.lesson24_optional_dependency;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Optional Dependency
 * <p>
 * - Secara default, semua dependency itu wajib
 * - Artinya  jika Spring tidak bisa menemukan bean yang dibutuhkan pada saat DI, maka secara otomatis akan terjadi error
 * - Namun jika kita memang ingin membuat sebuah dependency menjadi Optional, artinya tidak wajib
 * - Kita bisa wrap dependency tersebut dengan menggunakan java.util.Optional<T>
 * - Secara otomatis jika ternyata bean yang dibutuhkan tidak ada, maka tidak akan terjadi error
 * - Kita bisa gunakan Optional<T> pada @Bean (method parameter) ataupun @Component (constructor parameter, setter method
 * parameter, field)
 */
public class OptionalDependencyTest {

    @Test
    void optionalDependency() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo = context.getBean(Foo.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertNull(fooBar.getBar());
    }

    /**
     * Object Provider
     * <p>
     * - Selain menggunakan java.util.Optional<T>, kita juga bisa menggunakan ObjectProvider<T>
     * - Yang membedakan pada ObjectProvider<T> adalah, jika ternyata bean nya lebih dari satu, ObjectProvider<T> bisa
     * digunakan untuk mengambil semua bean tersebut
     * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ObjectProvider.html
     */
    @Test
    void objectProvider() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        MultiFoo multiFoo = context.getBean(MultiFoo.class);

        Assertions.assertEquals(2, multiFoo.getFoos().size());
    }
}
