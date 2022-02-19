package java18_spring_dasar.lesson19_component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Component
 * <p>
 * - Sebelumnya kita sudah belajar membuat bean menggunakan method di configuration dengan annotation @Bean
 * - Spring juga menyediakan cara otomatis tanpa harus kita membuat method @Bean
 * - Kita bisa menandai sebuah class dengan annotation @Component, secara otomatis Spring akan membuatkan bean untuk
 * class tersebut
 * - @Component hanya mendukung pembuatan satu bean, jadi jika kita ingin membuat beberapa bean dengan tipe yang sama,
 * kita tetap harus menggunakan @Bean method
 * <p>
 * Component Bean Name
 * <p>
 * - Saat kita menggunakan @Component, nama bean akan secara otomatis dibuat otomatis oleh Spring
 * - Jika kita menggunakan @ComponentScan, secara otomatis bean name secara otomatis akan menggunakan nama class namun
 * menjadi camelCase, misal CategoryService menjadi categoryService, ProductWeb menjadi productWeb
 * - Jika kita menggunakan @Import, secara otomatis bean name akan menjadi NamaClass.class.getName()
 * - Namun jika ingin membuat nama berbeda, kita juga bisa gunakan @Component(value=”namaBean”)
 * <p>
 * Annotation
 * <p>
 * - Semua annotation yang sudah kita bahas di @Bean juga didukung di @Component
 * - Seperti misalnya @Scope, @PostConstruct, @PreDestroy, @Lazy, @Primary dan lain-lain
 */
public class ComponentTest {

    @Test
    void component() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        CustomerService customerService = context.getBean("MyCustomerService", CustomerService.class);

        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(customerService);
    }
}
