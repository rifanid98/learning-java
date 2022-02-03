package java15_validation.lesson04_nested_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Nested Validation
 *
 * - Secara default, jika terdapat nested object, Bean Validation tidak akan melakukan validasi terhadap data object
 *   tersebut
 * - Misal kita punya class Person, dimana  memiliki field address dengan tipe class Address,  secara default isi dalam
 *   class Address tidak akan divalidasi
 * - Jika kita ingin melakukan validasi terhadap nested object tersebut, kita perlu menambahkan annotation @Valid
 * - @Valid juga bisa digunakan untuk nested object yang terdapat di dalam Array atau Collection
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valid
 */
public class NestedValidationTest {

    @Test
    void nestedValidation() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = new Person();
        person.setFirstName("Adnin");
        person.setLastName("Rifandi");
        person.setAddress(new Address());

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("==========================");
        }

        validatorFactory.close();
    }
}
