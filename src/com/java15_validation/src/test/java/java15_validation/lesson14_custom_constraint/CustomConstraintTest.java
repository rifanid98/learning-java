package java15_validation.lesson14_custom_constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Custom Constraint
 * <p>
 * - Sampai saat ini, kita hanya menggunakan Constraint Built-In yang terdapat di Bean Validation dan Hibernate Validator
 * - Bagaimana jika ternyata Constraint Built-In tersebut tidak bisa memenuhi kebutuhan validasi kita?
 * - Maka kita bisa membuat Constraint sendiri, atau istilahnya Custom Constraint
 * - Untuk membuat Constraint, kita perlu mengikuti aturan nya, pertama kita buat Constraint Annotation, lalu kita buat
 * ConstraintValidator
 * <p>
 * Check Case Constraint
 * <p>
 * - Misal, sekarang kita akan membuat sebuah constraint validation yang digunakan untuk melakukan pengecekan case sebuah
 * string
 * - Agar dinamis, kita akan tambahkan method mode() nya di constraint, yang bisa dipilih apakah harus UPPER atau lower
 */
public class CustomConstraintTest {

    @Test
    void customConstraint() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Order order = new Order();
        order.setAmount(10L);
        order.setId("123456789a");

        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        for (ConstraintViolation<Order> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getMessage());
        }
    }
}
