package java18_spring_dasar.lesson13_scope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Scope
 * <p>
 * - Scope merupakan strategy cara sebuah object dibuat
 * - Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan
 * mengembalikan object yang sama
 * - Namun kita juga bisa mengubah scope bean yang kita mau di Spring
 * - Untuk mengubah scope sebuah bean, kita bisa tambahkan annotation @Scope(value=”namaScope”)
 */
public class ScopeTest {

    @Test
    void scope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class); // Foo belum dibuat
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Foo foo3 = context.getBean(Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo2, foo3);
        Assertions.assertNotSame(foo3, foo1);
    }
}
