package java15_validation.lesson16_class_level_constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Class-Level Constraint
 *
 * - Sebelumnya kita hanya membuat Constraint pada Field, Method, dan Constructor
 * - Constraint juga  bisa kita tambahkan pada level class
 * - Hal ini kadang bermanfaat, seperti misal kita ingin membandingkan lebih dari satu Field misalnya
 * - Untuk membuat Class-Level Constraint, kita cukup tambahkan Annotation Constraint pada Class, dan pastikan saat
 *   membuat Constraint, tambahkan target Class
 */
public class ClassLevelConstraintTest {

    @Test
    void classLevelConstraint() {
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
