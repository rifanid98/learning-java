package java15_validation.lesson10_method_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import java15_validation.lesson09_payload.EmailErrorPayload;
import java15_validation.lesson09_payload.Payment;
import java15_validation.lesson09_payload.group.PaymentGroup;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Method Validation
 *
 * - Sampai saat ini kita baru hanya melakukan validasi pada object yang kita buat secara manual
 * - Bean Validation sendiri bisa digunakan untuk melakukan validasi di Method, baik itu Method Parameter atau Return
 *   Value
 * - Fitur ini memudahkan kita karena cukup menambahkan Annotation Constraint di Method Parameter
 *
 * ExecutableValidator
 *
 * - Untuk melakukan validasi di Method, kita butuh object ExecutableValidator
 * - Untuk membuat ExecutableValidator, kita bisa gunakan method forExecutables() di Validator
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/executable/executablevalidator
 */
public class MethodValidationTest {

    @Test
    void methodValidation() throws NoSuchMethodException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();

        Person person = new Person();
        String name = "";

        Method method = person.getClass().getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("LeafBean : " + violation.getLeafBean());
            System.out.println("ConstraintDescriptor : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("InvalidValue : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===============================");
        }
    }

    @Test
    void validateMethodReturnValue() throws NoSuchMethodException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();

        Person person = new Person();
        person.setFirstName("Adnin");
        person.setLastName("Rifandi");

        Method method = person.getClass().getMethod("getFullName");
        String returnValue = person.getFullName();

        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("LeafBean : " + violation.getLeafBean());
            System.out.println("ConstraintDescriptor : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("InvalidValue : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===============================");
        }
    }
}
