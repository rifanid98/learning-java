package java18_spring_dasar.lesson16_lifecycle_annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Life Cycle Annotation
 * <p>
 * - Selain menggunakan interface InitializingBean dan DisposableBean, kita juga bisa menggunakan annotation untuk
 * mendaftarkan callback method untuk lifecycle
 * - Pada annotation @Bean, terdapat method initMethod() dan destoyMethod()
 * - initMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai dibuat
 * - destroyMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean akan dihancurkan
 * - Methodnya harus tanpa parameter, dan return value nya tidak akan dipedulikan, jadi sebaiknya gunakan void saja
 */
public class LifecycleAnnotationTest {

    @Test
    void lifecycleAnnotation() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Server server = context.getBean(Server.class);
        context.close();
    }

    /**
     * @PostConstruct dan @PreDestroy
     * <p>
     * - Selain menggunakan annotation @Bean, untuk menandai sebuah method adalah init method dan destroy method, kita
     * juga bisa menggunakan annotation pada method nya secara langsung
     * - Ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat @Bean
     * - @PostConstruct merupakan method yang ditandai harus dipanggil ketika bean selesai dibuat
     * - @PreDestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
     * - Jika sudah menggunakan annotation ini, kita tidak perlu lagi menyebutkan nya di @Bean
     */
    @Test
    void postConstructAndPreDestroy() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Server server = context.getBean(Server.class);
        context.close();
    }
}
