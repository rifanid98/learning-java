package java18_spring_dasar.lesson34_spring_boot_application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring Boot Test
 * <p>
 * - Untuk membuat unit test di Spring Boot, kita bisa menggunakan annotation @SpringBootTest(classes={YourConfiguration.class})
 * - Selanjutnya kita tidak perlu mengambil bean secara manual lagi menggunakan ApplicationContext, kita bisa menggunakan
 * DI secara langsung di unit test nya menggunakan @Autowired
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html
 */
@SpringBootTest(classes = FooApplication.class)
public class FooApplicationTest {

    @Autowired
    Foo foo;

    @Test
    void testFoo() {
        Assertions.assertNotNull(foo);
    }
}
