package java18_spring_dasar.lesson11_depends_on;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Depends On
 * <p>
 * - Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat
 * - Namun bagaimana jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean
 * lain dibuat?
 * - Jika ada kasus seperti itu, kita bisa menggunakan annotation @DependsOn(value={”namaBean”})
 * - Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu
 */
public class DependsOnTest {

    @Test
    void dependsOn() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }
}
