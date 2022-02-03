package java15_validation.lesson06_grouping_constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java15_validation.lesson06_grouping_constraint.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Grouping Constraints
 * <p>
 * - Secara default, saat Validator melakukan validasi, validator akan memvalidasi semua field yang memiliki constraint
 * - Kadang, ada saatnya misal kita ingin melakukan pengecekan beberapa hal saja pada kondisi tertentu, misal terdapat
 * satu class yang digunakan untuk beberapa aksi, sehingga membutuhkan kombinasi validasi yang berbeda
 * - Dalam kasus ini, kita bisa menggunakan Grouping Constraints
 * - Grouping Constraint merupakan teknik mengelompokkan constraint yang terdapat di class
 * - Dengan menambahkan group, saat melakukan validasi, kita bisa memilih group mana yang akan divalidasi
 * - Setiap constraint bisa memiliki lebih dari satu grup
 */
public class GroupingConstraintsTest {

    @Test
    void groupingConstraint() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===============================");
        }
    }

    @Test
    void groupingConstraintDefaultGroup() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===============================");
        }
    }
}
