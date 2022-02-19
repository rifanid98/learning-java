package java18_spring_dasar.lesson21_setter_based_dependency_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Setter-based Dependency Injection
 * <p>
 * - Selain menggunakan constructor parameter, kita juga bisa menggunakan setter method jika ingin melakukan dependency
 * injection
 * - Namun khusus untuk setter method, kita perlu menambah annotation @Autowired pada setter method nya
 * - Secara otomatis Spring akan mencari bean yang dibutuhkan di setter method yang memiliki annotation @Autowired
 * - Setter-based DI juga bisa digabung dengan Constructor-based DI
 */
public class SetterBasedDependencyInjection {

    @Test
    void setterBasedDependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

        Assertions.assertNotNull(categoryService);
        Assertions.assertNotNull(categoryRepository);
    }
}
