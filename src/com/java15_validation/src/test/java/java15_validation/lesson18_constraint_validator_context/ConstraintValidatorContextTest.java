package java15_validation.lesson18_constraint_validator_context;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Constraint Validator Context
 * <p>
 * - Saat kita membuat ConstraintValidator, pada method isValid terdapat parameter ConstraintValidatorContext
 * - Sebenarnya dalam keadaan ideal, kita tidak butuh menggunakan parameter tersebut, tapi pada materi ini kita akan
 * bahas kegunaannya
 * - ConstraintValidatorContext digunakan untuk membuat custom message atau path, jika dirasa memang diperlukan
 * - Contoh pada kasus Class-Level Constraint, ketika terjadi error, maka secara default path nya adalah root objectnya,
 * kadang-kadang kita ingin memberi tahu field mana yang error. Pada kasus ini kita bisa menggunakan ConstraintValidatorContext
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintvalidatorcontext
 */
public class ConstraintValidatorContextTest {

    @Test
    void constraintValidatorContext() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Register register = new Register();
        register.setPassword("password");
        register.setRetypePassword("PassworD");

        Set<ConstraintViolation<Register>> violations = validator.validate(register);
        for (ConstraintViolation<Register> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
