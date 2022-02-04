package java15_validation.lesson17_cross_parameter_constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Cross-Parameter Constraint
 *
 * - Untuk melakukan validasi beberapa Field, kita bisa menggunakan fitur Class-Level Constraint
 * - Sekarang bagaimana jika kita ingin melakukan validasi beberapa Parameter? Misal pada Method Parameter atau
 *   Constructor Parameter?
 * - Hal ini tidak bisa menggunakan Class-Level Constraint, namun ada cara sendiri untuk melakukan hal ini
 * - Yaitu dengan menggunakan Annotation @SupportedValidationTarget
 * - Kita bisa menggunakan @SupportedValidationTarget pada ConstraintValidator, untuk melakukan validasi semua parameter
 *   di Method atau Constructor
 */
public class CrossParameterConstraintTest {

    @Test
    void crossParameterConstraint() throws NoSuchMethodException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        UserService userService = new UserService();
        Class<? extends UserService> userServiceClass = userService.getClass();
        Method method = userServiceClass.getMethod("register", String.class, String.class, String.class);

        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{
                "username", "password", "passwordLagi"
        });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
