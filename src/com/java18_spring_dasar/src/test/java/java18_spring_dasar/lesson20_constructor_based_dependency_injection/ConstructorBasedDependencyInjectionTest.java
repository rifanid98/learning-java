package java18_spring_dasar.lesson20_constructor_based_dependency_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Dependency Injection
 * <p>
 * - Sebelumnya untuk melakukan Dependency Injection di @Bean, kita bisa menambah parameter di method nya
 * - Secara otomatis Spring akan memilih bean mana yang cocok untuk parameter tersebut
 * - Bagaimana jika menggunakan @Component?
 * - Untuk @Component kita bisa melakukan beberapa cara untuk Dependency Injection nya
 * <p>
 * Constructor-based Dependency Injection
 * <p>
 * - Pertama yang bisa kita lakukan untuk Dependency Injection di @Component adalah menggunakan constructor parameter
 * - Kita bisa menambahkan constructor yang memiliki parameter jika membutuhkan bean lain
 * - Secara otomatis Spring akan mencarikan bean tersebut, dan ketika membuat bean @Component, Spring akan menggunakan
 * bean yang dibutuhkan di constructor
 * - Constructor-based Dependency Injection hanya mendukung satu constructor, jadi pastikan kita hanya membuat satu
 * constructor
 */
public class ConstructorBasedDependencyInjectionTest {

    @Test
    void constructorBasedDependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(productRepository);
    }

    /**
     * Multiple Constructor
     * <p>
     * - Seperti di awal disebutkan bahwa Spring hanya mendukung satu constructor untuk Dependency Injection nya
     * - Namun bagaimana jika terdapat multiple constructor?
     * - Jika pada kasus seperti ini, kita harus menandai constructor mana yang akan digunakan oleh Spring
     * - Caranya kita bisa menggunakan annotation @Autowired
     */
    @Test
    void multipleConstructor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(productRepository);
    }
}
