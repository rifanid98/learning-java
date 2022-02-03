package java15_validation.lesson07_grouping_sequence;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java15_validation.lesson07_grouping_sequence.group.PaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Group Sequence
 * <p>
 * - Saat kita melakukan validasi dengan beberapa group, tidak ada jaminan bahwa sebuah group akan dijalankan sebelum
 * group yang lain
 * - Bean Validation memiliki annotation GroupSequence, ini digunakan untuk menentukan tahapan grup mana terlebih dahulu
 * yang akan di validasi
 * - Kita bisa membuat group baru, lalu tambahkan annotation @GroupSequence, atau langsung di class nya
 * - Saat terjadi error validasi pada sebuah group, maka secara otomatis tidak akan dilanjutkan ke group selanjutnya
 */
public class GroupSequenceTest {

    @Test
    void groupSequence() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, PaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("LeafBean : " + violation.getLeafBean());
            System.out.println("ConstraintDescriptor : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("InvalidValue : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===============================");
        }
    }
}
