package java18_spring_dasar.lesson12_lazy_bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Lazy Bean
 * <p>
 * - Secara default, bean di Spring akan dibuat ketika aplikasi Spring pertama kali berjalan
 * - Oleh karena itu, kadang ketika aplikasi Spring pertama berjalan akan sedikit lambat, hal ini dikarenakan semua bean
 * akan dibuat di awal
 * - Namun jika kita mau, kita juga bisa membuat sebuah bean menjadi lazy (malas), dimana bean tidak akan dibuat, sampai
 * memang diakses atau dibutuhkan
 * - Untuk membuat sebuah bean menjadi lazy, kita bisa tambahkan annotation @Lazy pada bean tersebut
 */
public class LazBeanTest {

    @Test
    void lazyBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class); // Foo belum dibuat
        // Foo bean = context.getBean(Foo.class); // Foo dibuat
    }
}
