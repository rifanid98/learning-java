package java15_validation.lesson11_constructor_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * Constructor Validation
 *
 * - ExecutableValidator tidak hanya bisa digunakan untuk melakukan validasi terhadap Method Parameter dan Method Return
 *   Value, tapi juga ke Constructor Parameter dan Constructor Return Value
 * - Cara penggunaannya sama dengan melakukan validasi di Method, yang berbeda hanya method yang digunakannya
 */
public class ConstructorValidationTest {

    @Test
    void constructorParameterValidation() throws NoSuchMethodException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{"", "", null});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());
        }
    }

    @Test
    void constructorReturnValueValidation() throws NoSuchMethodException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        Person person = new Person("", "", null);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructor, person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());
        }
    }
}
