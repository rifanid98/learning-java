package java18_spring_dasar.lesson02_application_context;

import java18_spring_dasar.HelloWorldConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application Context
 * <p>
 * - ApplicationContext adalah sebuah interface representasi container IoC di Spring
 * - ApplicationContext adalah inti dari Spring Framework
 * - ApplicationContext banyak sekali class implementasinya, secara garis besar dibagi menjadi 2 jenis implementasi, XML
 * dan Annotation
 * - Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang beralih dari XML ke
 * Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html
 * <p>
 * Configuration
 * <p>
 * - Untuk membuat ApplicationContext menggunakan Annotation, pertama kita bisa perlu membuat Configuration class
 * - Configuration Class adalah sebuah class yang terdapat annotation @Configuration pada class tersebut
 */
public class ApplicationContextTest {

    @Test
    void applicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        Assertions.assertNotNull(context);
    }
}
