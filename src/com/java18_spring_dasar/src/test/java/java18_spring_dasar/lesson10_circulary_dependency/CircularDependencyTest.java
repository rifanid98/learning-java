package java18_spring_dasar.lesson10_circulary_dependency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Circular Dependencies
 * <p>
 * - Hati-hati dengan curcular dependencies
 * - Circular dependencies adalah kasus dimana sebuah lingkaran dependency terjadi, misal bean A membutuhkan bean B,
 * bean B membutuhkan bean C, dan ternyata bean C membutuhkan A
 * - Jika terjadi cyclic seperti ini, secara otomatis Spring bisa mendeteksinya, dan akan mengganggap bahwa itu adalah
 * error
 */
public class CircularDependencyTest {

    @Test
    void circularDependency() {
        Assertions.assertThrows(Throwable.class, () -> {
            ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        });
    }
}
