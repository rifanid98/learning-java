package java15_validation.lesson12_message_interpolation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Message Interpolation
 *
 * - Message Interpolation merupakan proses membuat pesan error ketika terjadi kesalahan pada constraint
 * - Secara default, pesan kesalahan akan diambil dari method message() milik constraint
 *
 * Special Character
 *
 * - Message Interpolation memiliki karakter spesial yaitu { dan }, oleh karena itu jika kita ingin menggunakan karakter
 *   tersebut, kita perlu tambahkan \ didepannya, misal \{ atau \}
 * - Kadang ketika kita membuat pesan kesalahan, kita ingin  mengambil value dari constraint nya, kita bisa menambahkan
 *   {method} yang terdapat di constraint nya, secara otomatis nilai di constraint  akan ditambahkan ke message nya
 */
public class MessageInterpolationTest {

    @Test
    void messageInterpolation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Order order = new Order();
        order.setAmount(10L);
        order.setId("1234567890123");

        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        for (ConstraintViolation<Order> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getMessage());
        }
    }

    /**
     * Resource Bundle
     *
     * - Selain hardcode pesan di dalam method message(), Bean Validation juga mendukung resource bundle, dimana kita
     *   bisa menyimpan semua pesan kesalahan di file properties
     * - Hal ini sangat bagus ketika kita butuh mendukung pesan kesalahan dengan beberapa bahasa
     * - Caranya kita cukup buat file ValidationMessages.properties
     */
    @Test
    void messageInterpolationUsingResourceBundle () {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        OrderWithResourceBundle order = new OrderWithResourceBundle();
        order.setAmount(10L);
        order.setId("1234567890123");

        Set<ConstraintViolation<OrderWithResourceBundle>> violations = validator.validate(order);
        for (ConstraintViolation<OrderWithResourceBundle> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getMessage());
        }
    }
}
