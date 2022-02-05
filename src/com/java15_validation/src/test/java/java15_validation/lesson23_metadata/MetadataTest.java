package java15_validation.lesson23_metadata;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.metadata.BeanDescriptor;
import org.junit.jupiter.api.Test;

/**
 * Metadata
 *
 * - Materi ini sebenarnya bisa kita tangani dengan menggunakan Reflection
 * - Namun Bean Validation memberikan fitur untuk mempermudah kita
 * - Bean Validation memungkinkan kita melihat sebuah constraint yang terdapat di sebuah class
 * - Kita bisa melihat detail dari constraint tersebut, mirip seperti ketika kita melihat semua struktur class
 *   menggunakan Java Reflection
 * - Metadata untuk constraint, disimpan dalam object BeanDescriptor
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/metadata/beandescriptor
 */
public class MetadataTest {

    @Test
    void metadata() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);

        System.out.println(beanDescriptor.getConstrainedConstructors());
        System.out.println(beanDescriptor.getConstrainedProperties());
        System.out.println(beanDescriptor.getConstraintsForConstructor());
        System.out.println(beanDescriptor.getConstraintDescriptors());
    }
}
