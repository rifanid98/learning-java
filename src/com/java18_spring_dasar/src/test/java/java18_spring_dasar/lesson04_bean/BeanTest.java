package java18_spring_dasar.lesson04_bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean
 * <p>
 * - Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean
 * - Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan
 * object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri
 * <p>
 * Membuat Bean
 * <p>
 * - Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration
 * - Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya
 * - Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
 * - Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara
 * otomatis, dan disimpan di container IoC
 */
public class BeanTest {

    /**
     * Mengakses Bean
     * <p>
     * - Setelah kita membuat bean, secara otomatis semua object akan di-manage oleh Application Context
     * - Untuk mengakses bean, kita bisa menggunakan method getBean milik Application Context
     */
    @Test
    void bean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);

        Assertions.assertSame(foo1, foo2);
    }
}
