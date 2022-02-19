package java18_spring_dasar.lesson22_field_based_dependency_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Field-based Dependency Injection
 * <p>
 * - Selain constructor dan setter, kita juga bisa melakukan dependency injection langsung menggunakan field
 * - Caranya sama dengan setter, kita bisa tambahkan @Autowired pada fieldnya
 * - Secara otomatis Spring akan mencari bean dengan tipe data tersebut
 * - Field-based DI bisa digabung sekaligus dengan Setter-based DI dan Constructor-based DI
 * - Khusus Field-based DI, Spring sendiri sudah tidak merekomendasikan penggunaan cara melakukan DI dengan Field
 */
public class FieldBasedDependencyInjectionTest {

    @Test
    void fieldBasedDependencyInjection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

        Assertions.assertNotNull(customerService);
        Assertions.assertNotNull(customerService.getCustomerRepository());
        Assertions.assertNotNull(customerRepository);
    }
}
