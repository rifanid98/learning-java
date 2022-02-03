package java15_validation.lesson09_payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java15_validation.lesson09_payload.group.PaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Payload
 * <p>
 * - Secara default aturan Annotation Constraint di Bean Validation selain memiliki method message() dan groups(), ada
 * juga payload()
 * - Untuk apa payload()?
 * - Method payload() itu sendiri sebenarnya tidak digunakan sama sekali oleh Bean Validation, namun method ini bisa
 * digunakan oleh kita untuk menambah informasi ketika menggunakan constraint
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/payload
 */
public class PayloadTest {

    @Test
    void payload() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, PaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            violation.getConstraintDescriptor().getPayload().forEach(aClass -> {
                if (aClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            });
        }
    }
}
