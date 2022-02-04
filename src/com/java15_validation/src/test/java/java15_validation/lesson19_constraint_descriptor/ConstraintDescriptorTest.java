package java15_validation.lesson19_constraint_descriptor;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Constraint Descriptor
 *
 * - Pada materi-materi sebelumnya, beberapa kali kita sudah menggunakan Constraint Descriptor, namun belum terlalu
 *   detail, seperti contohnya ketika mendapatkan Payload
 * - ConstraintDescriptor merupakan sebuah interface, yang berisikan informasi tentang Constraint
 * - Kita bisa mendapatkan informasi seperti Annotation, Group, Validator Class, Message Template, bahkan Annotation
 *   Method menggunakan ConstraintDescriptor
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/metadata/constraintdescriptor
 */
public class ConstraintDescriptorTest {

    @Test
    void constraintDescriptor() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = new Person();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getConstraintDescriptor().getAttributes());
            System.out.println(violation.getConstraintDescriptor().getPayload());
            System.out.println(violation.getConstraintDescriptor().getGroups());
            System.out.println("==============");
        }
    }
}
