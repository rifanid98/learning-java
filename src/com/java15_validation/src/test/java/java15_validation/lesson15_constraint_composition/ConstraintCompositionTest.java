package java15_validation.lesson15_constraint_composition;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Constraint Composition
 * <p>
 * - Jika kita perhatikan pada Order.id, kita lihat terdapat 3 constraint annotation, @Size, @NotBlank dan @CheckCase.
 * Bahkan pada skenario tertentu, bisa jadi akan sangat banyak sekali constraint pada sebuah field, yang semakin lama
 * akan semakin membingungkan
 * - Bean Validation mendukung Constraint Composition, dimana kita bisa membuat Constraint baru yang didalamnya
 * sebenarnya adalah kumpulan Constraint lainnya
 * - Caranya sangat mudah,  kita cukup membuat Constraint Annotation, lalu tambahkan Constraint Annotation lain pada
 * Constraint yang kita buat
 */
public class ConstraintCompositionTest {

    @Test
    void constraintComposition() {
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

    /**
     * @ReportAsSingleViolation - Secara default, semua Constraint di Constraint Composite akan dieksekusi, jadi jika misal  terdapat lebih dari
     * satu error, maka semua error akan diberitahukan
     * - Kadang ada baiknya, jika misal terdapat satu constraint yang error, kita tidak perlu lakukan pengecekan ke
     * constraint berikutnya
     * - Untuk melakukan hal ini, kita bisa tambahkan annotation @ReportAsSingleViolation pada Composite Constraint
     * Annotation
     */
    @Test
    void reportAsSingleViolation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Order_AsSingleViolation order = new Order_AsSingleViolation();
        order.setId("123456789a");
        order.setAmount(0L);

        Set<ConstraintViolation<Order_AsSingleViolation>> violations = validator.validate(order);
        for (ConstraintViolation<Order_AsSingleViolation> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getMessage());
        }
    }
}
