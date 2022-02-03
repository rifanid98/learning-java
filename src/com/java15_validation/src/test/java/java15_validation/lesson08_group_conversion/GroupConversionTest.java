package java15_validation.lesson08_group_conversion;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java15_validation.lesson08_group_conversion.group.PaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Group Conversion
 *
 * - Kadang ada kasus dimana terdapat sebuah class yang sudah memiliki field group, namun ternyata kita membutuhkan class
 *   tersebut di embed di class lain, sedangkan class lain menggunakan group berbeda
 * - Pada kasus seperti ini, kita bisa melakukan konversi grup
 * - Untuk melakukan konversi group, kita bisa menggunakan annotation @ConvertGroup, lalu tentukan dari group apa ke
 *   group apa
 */
public class GroupConversionTest {

    @Test
    void groupConversion() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("411212212");
        payment.setCreditCard("4308257076870");
        payment.setCustomer(new Customer("Adnin", "adnin@email.com"));

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
