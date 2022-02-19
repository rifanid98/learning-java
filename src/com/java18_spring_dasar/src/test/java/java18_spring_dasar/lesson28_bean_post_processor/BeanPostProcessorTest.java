package java18_spring_dasar.lesson28_bean_post_processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean Post Processor
 * <p>
 * - Bean Post Processor merupakan sebuah interface yang bisa kita gunakan untuk memodifikasi proses pembuatan bean di
 * Application Context
 * - Bean Post Processor mirip seperti middleware, yang diakses sebelum bean di initialized dan setelah bean di initialized
 * - Karena sangat flexible, bahkan Bean Post Processor bisa memodifikasi hasil object bean
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html
 * <p>
 * Bean Id Generator
 * <p>
 * - Misal sekarang kita akan coba membuat id unique untuk bean
 * - Dimana kita akan membuat sebuah interface bernama IdAware, lalu memiliki method setId(String)
 * - Kita akan membuat Bean Post Processor, dimana jika bean nya implements IdAware, kita akan setId(String) nya
 * menggunakan UUID
 */
public class BeanPostProcessorTest {

    @Test
    void beanPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Car car = context.getBean(Car.class);

        Assertions.assertNotNull(car);
        Assertions.assertNotNull(car.getId());
    }
}
