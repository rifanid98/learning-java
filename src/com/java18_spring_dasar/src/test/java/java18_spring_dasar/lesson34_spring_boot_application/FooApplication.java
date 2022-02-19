package java18_spring_dasar.lesson34_spring_boot_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot Application
 * <p>
 * - Sebelumnya kita selalu membuat Application Context secara manual, dan kita belum menggunakan fitur otomatis Spring
 * Boot
 * - Hal ini sengaja saya jelaskan agar kita tidak kaget bagaimana semua itu bisa berjalan secara otomatis di Spring Boot
 * - Pada saat membuat aplikasi Spring Boot, kita akan mengganti @Configuration utama menjadi @SpringBootApplication
 * - Isi dari @SpringBootApplication itu sendiri sebenarnya gabungan dari @Configuration dan banyak hal lain, seperti
 * contohnya @ComponentScan
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
 */
@SpringBootApplication
public class FooApplication {

    /**
     * Spring Application
     * <p>
     * - Selain @SpringBootApplication, untuk membuat Application Context nya, kita tidak perlu membuat manual, kita
     * bisa gunakan class SpringApplication
     * - Secara otomatis SpringApplication akan membuat ApplicationContext dan melakukan hal-hal yang dibutuhkan secara
     * otomatis
     * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FooApplication.class, args);
        Foo foo = context.getBean(Foo.class);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }
}
