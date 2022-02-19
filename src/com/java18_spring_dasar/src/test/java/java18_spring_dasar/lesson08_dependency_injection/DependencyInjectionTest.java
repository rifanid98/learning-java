package java18_spring_dasar.lesson08_dependency_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Dependency Injection
 * <p>
 * - Saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain
 * - Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung
 * dengan object lain, atau kita sebut dependencies
 * - Dependencies akan secara otomatis di-inject (dimasukkan) kedalam object yang membutuhkannya
 * - Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan Dependency Injection
 * <p>
 * Tanpa Dependency Injection
 * <p>
 * - Sebenarnya tanpa Dependency Injection pun, kita tetap bisa membuat aplikasi
 * - Namun ketika relasi antar dependencies sangat kompleks, agak ribet untuk kita melakukannya jika harus manual
 * - Oleh karena itu, penggunaan Dependency Injection framework seperti Spring sangat membantu sekali
 */
public class DependencyInjectionTest {

    @Test
    void withoutDependencyInjection() {
        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    /**
     * Spring Dependency Injection
     * <p>
     * - Spring sejak awal dikenal dengan framework untuk Dependency Injection
     * - Ketika kita membuat method untuk bean di Spring, kita bisa menambahkan parameter
     * - Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut
     * - Jika ternyata tidak ada bean yang cocok, maka secara otomatis akan terjadi error
     * - Dan jika ternyata terdapat bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean
     */
    @Test
    void dependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
