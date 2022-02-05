package java15_validation.lesson22_constraint_violation_exception;

import jakarta.validation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * Constraint Violation Exception
 *
 * - Bean Validation secara default tidak membuat Exception ketika terjadi validasi error
 * - Bean Validation hanya mengembalikan error validasi dalam bentuk Set berisi Constraint Violation
 * - Beberapa framework atau library, kadang menginginkan Exception jika terjadi validasi error
 * - Kita tidak butuh  membuat exception secara manual, Bean Validation sudah menyediakannya, yaitu
 *   ConstraintViolationException
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolationexception
 */
public class ContraintViolationExceptionTest {

    @Test
    void constraintViolationException() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        try {
            Person person = new Person();
            Set<ConstraintViolation<Person>> violations = validator.validate(person);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
    }
}
