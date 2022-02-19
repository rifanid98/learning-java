package java18_spring_dasar.lesson35_startup_failure;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Startup Failure
 * <p>
 * - Salah satu yang menarik di Spring Boot adalah, Spring Boot memiliki fitur FailureAnalyzer
 * - FailureAnalyzer digunakan untuk melakukan analisa ketika terjadi error startup yang menyebabkan aplikasi tidak mau
 * berjalan
 * - Spring sudah menyediakan banyak sekali class implementasi FailureAnalyzer yang bisa mempermudah kita menganalisa
 * kesalaha ketika terjadi startup failure
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/diagnostics/FailureAnalyzer.html
 */
public class StartupFailureTest {

    @Test
    void startupFailure() {
        ApplicationContext context = new AnnotationConfigApplicationContext(FooApplication.class);
        Foo foo = context.getBean(Foo.class);
    }
}
