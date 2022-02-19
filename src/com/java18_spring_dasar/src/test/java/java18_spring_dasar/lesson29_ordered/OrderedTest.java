package java18_spring_dasar.lesson29_ordered;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Ordered
 * <p>
 * - Saat kita membuat Bean Post Processor, kita bisa membuat lebih dari satu
 * - Kadang ada kasus saat membuat beberapa Bean Post Processor, kita ingin membuat yang berurutan
 * - Sayangnya secara default, Spring tidak menjamin urutan eksekusi nya
 * - Agar kita bisa menentukan urutannya, kita bisa menggunakan interface Ordered
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/Ordered.html
 */
public class OrderedTest {

    @Test
    void ordered() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Car car = context.getBean(Car.class);

        Assertions.assertNotNull(car);
        Assertions.assertNotNull(car.getId());
        Assertions.assertEquals("PZN", car.getId().split("-")[0]);
    }
}
